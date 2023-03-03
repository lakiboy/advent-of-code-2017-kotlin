package io.dmitrijs.aoc2017

class Day24(input: List<String>) {
    private val components = input.map { Component.of(it) }

    fun puzzle1() = components.filter { it.matches(port = 0) }.maxOf { extractBridge(it) }

    private fun extractBridge(start: Component): Int {
        val queue = ArrayDeque<Connection>()
        val visited = hashSetOf(start)
        var result = -1

        queue.add(start.connect(0))

        while (queue.isNotEmpty()) {
            val (port, strength) = queue.removeFirst()
            result = maxOf(result, strength)

            port.connections.filterNot { it in visited }.forEach { neighbour ->
                queue.add(neighbour.connect(port, strength))
                visited.add(neighbour)
            }
        }

        return result
    }

    private val Int.connections get() = components.filter { it.matches(port = this) }

    private data class Connection(val port: Int, val strength: Int)

    private data class Component(val l: Int, val r: Int) {
        private val weight get() = l + r

        fun matches(port: Int) = l == port || r == port

        fun connect(port: Int, strength: Int = 0) = Connection(
            port = if (l == port) r else l,
            strength = strength + weight,
        )

        companion object {
            fun of(input: String) = Component(
                input.substringBefore("/").toInt(),
                input.substringAfter("/").toInt(),
            )
        }
    }
}
