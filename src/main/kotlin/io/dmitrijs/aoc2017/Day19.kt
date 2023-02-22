package io.dmitrijs.aoc2017

import io.dmitrijs.aoc2017.Direction.DOWN

class Day19(input: List<String>) {
    private val map = input.map { " $it" } // Easier to check with padding.
    private val result by lazy { solve() }

    fun puzzle1() = result.first

    fun puzzle2() = result.second

    private fun solve(): Pair<String, Int> {
        var goto = DOWN
        var prev = Point(map.first().indexOf('|'), 0)
        var path = ""
        var step = 0

        do {
            val node = prev + goto
            when (node.value) {
                in 'A'..'Z' -> path += node.value
                '+' -> goto = Direction.values().first { direction ->
                    val neighbour = node + direction
                    neighbour.valid && neighbour.value != prev.value
                }
            }
            prev = node
            step++
        } while (node.valid)

        return path to step
    }

    private val Point.valid get() = y < map.size && x < map[y].length && value != ' '

    private val Point.value get() = map[y][x]
}
