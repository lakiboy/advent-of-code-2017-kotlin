package io.dmitrijs.aoc2017

import kotlin.math.absoluteValue

class Day07(input: List<String>) {
    private val programs = input.map { it.toProgram() }.associateBy { it.name }

    fun puzzle1(): String {
        val children = programs.values
            .flatMap { if (it.leaf) listOf(it.name) else it.children }
            .toSet()

        return (programs.keys - children).single()
    }

    fun puzzle2() = balanceNode(puzzle1())

    private tailrec fun balanceNode(name: String, diff: Int = 0): Int {
        val splitByWeight = programs
            .getValue(name)
            .children
            .groupBy { programs.getValue(it).totalWeight }

        if (splitByWeight.size > 1) {
            return balanceNode(
                name = splitByWeight.minBy { (_, nodes) -> nodes.size }.value.first(),
                diff = splitByWeight.keys.reduce { a, b -> a - b }.absoluteValue
            )
        }

        return programs.getValue(name).weight - diff
    }

    private val Program.totalWeight: Int get() = weight + if (leaf) 0 else childrenWeight

    private val Program.childrenWeight: Int get() = children.sumOf { programs.getValue(it).totalWeight }

    private data class Program(val name: String, val weight: Int, val children: List<String>) {
        val leaf get() = children.isEmpty()
    }

    private fun String.toProgram(): Program {
        val parts = split(" -> ")
        val match = """(\w+?) \((\d+)\)""".toRegex().find(parts.first())!!

        return Program(
            name = match.groupValues[1],
            weight = match.groupValues[2].toInt(),
            children = if (parts.size > 1) parts.last().split(", ") else emptyList()
        )
    }
}
