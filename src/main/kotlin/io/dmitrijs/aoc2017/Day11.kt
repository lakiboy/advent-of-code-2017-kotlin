package io.dmitrijs.aoc2017

import kotlin.math.absoluteValue

class Day11(input: String) {
    private val graph: Set<Point>
    private val goal: Point

    init {
        buildGraph(Point(0, 0), input).apply {
            graph = first
            goal = second
        }
    }

    fun puzzle1() = goal.distance

    fun puzzle2() = graph.maxOf { it.distance }

    private val Point.distance get() = (y.absoluteValue - x.absoluteValue) / 2 + x.absoluteValue

    private fun Point.moveTo(direction: String) = when (direction) {
        "n" -> copy(y = y - 2)
        "ne" -> copy(x = x + 1, y = y - 1)
        "se" -> copy(x = x + 1, y = y + 1)
        "s" -> copy(y = y + 2)
        "sw" -> copy(x = x - 1, y = y + 1)
        "nw" -> copy(x = x - 1, y = y - 1)
        else -> error("Invalid direction '$direction'.")
    }

    private fun buildGraph(start: Point, input: String): Pair<Set<Point>, Point> {
        val points = hashSetOf(start)
        var cursor = start

        input.split(",").forEach { direction ->
            cursor = cursor.moveTo(direction).also { points.add(it) }
        }

        return points to cursor
    }
}
