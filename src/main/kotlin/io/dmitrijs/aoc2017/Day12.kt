package io.dmitrijs.aoc2017

class Day12(input: List<String>) {
    private val groups = input.map { it.toGroup() }.associateBy { it.node }

    fun puzzle1() = captureGroup(0).size

    fun puzzle2(): Int {
        val allGroups = groups.keys.toMutableSet()
        var groupsNum = 0

        while (allGroups.isNotEmpty()) {
            allGroups -= captureGroup(allGroups.first()).also { groupsNum++ }
        }

        return groupsNum
    }

    // Could be shortened with recursion.
    private fun captureGroup(node: Int): Set<Int> {
        val queue = ArrayDeque(listOf(node))
        val visited = hashSetOf<Int>()

        while (queue.isNotEmpty()) {
            val num = queue.removeFirst().also { visited.add(it) }
            groups.getValue(num).children
                .filterNot { it in visited }
                .let { queue.addAll(it) }
        }

        return visited
    }

    private fun String.toGroup(): Group {
        val (head, children) = split(" <-> ")

        return Group(head.toInt(), children.split(", ").map { it.toInt() }.toSet())
    }

    private data class Group(val node: Int, val children: Set<Int>)
}
