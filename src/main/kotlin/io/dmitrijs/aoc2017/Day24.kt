package io.dmitrijs.aoc2017

class Day24(input: List<String>) {
    private val components = input.map { Component.of(it) }.toSet()
    private val connections: Map<Int, MutableList<Component>> = buildMap {
        components.forEach {
            getOrPut(it.l) { mutableListOf() }.add(it)
            getOrPut(it.r) { mutableListOf() }.add(it)
        }
    }

    fun puzzle1() = connections.getValue(0).maxOf { bestWeight(it).first }

    fun puzzle2() =
        connections
            .getValue(0)
            .map { bestWeight(it) }
            .sortedBy { it.first }
            .maxBy { it.second }
            .first

    private fun bestWeight(start: Component, longest: Boolean = false): Pair<Int, Int> {
        val queue = ArrayDeque<Bridge>()
        var result = Pair(-1, 0)

        queue.add(start.connect(port = 0))

        while (queue.isNotEmpty()) {
            val (nodes, port, strength) = queue.removeFirst()

            result = when {
                longest && nodes.size > result.second -> strength to nodes.size
                (longest && nodes.size == result.second) || !longest -> maxOf(strength, result.first) to nodes.size
                else -> result
            }

            connections
                .getValue(port)
                .subtract(nodes)
                .forEach { neighbour -> queue.add(neighbour.connect(port, nodes)) }
        }

        return result
    }

    private data class Bridge(
        val nodes: Set<Component>,
        val port: Int,
        val strength: Int = nodes.sumOf { it.weight }
    )

    private data class Component(val l: Int, val r: Int) {
        val weight get() = l + r

        fun connect(port: Int, nodes: Set<Component> = emptySet()) = Bridge(
            nodes = nodes + this,
            port = if (l == port) r else l,
        )

        companion object {
            fun of(input: String) = Component(
                input.substringBefore("/").toInt(),
                input.substringAfter("/").toInt(),
            )
        }
    }
}
