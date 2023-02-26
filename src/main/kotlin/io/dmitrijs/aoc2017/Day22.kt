package io.dmitrijs.aoc2017

import io.dmitrijs.aoc2017.Day22.Cluster.State.CLEAN
import io.dmitrijs.aoc2017.Day22.Cluster.State.FLAGGED
import io.dmitrijs.aoc2017.Day22.Cluster.State.INFECTED
import io.dmitrijs.aoc2017.Day22.Cluster.State.WEAKENED
import io.dmitrijs.aoc2017.Direction.DOWN
import io.dmitrijs.aoc2017.Direction.LEFT
import io.dmitrijs.aoc2017.Direction.RIGHT
import io.dmitrijs.aoc2017.Direction.UP

class Day22(private val input: List<String>) {
    fun puzzle1() =
        Cluster(input).apply {
            repeat(10_000) { simpleRun() }
        }.infections

    fun puzzle2() =
        Cluster(input).apply {
            repeat(10_000_000) { advancedRun() }
        }.infections

    private class Cluster(grid: List<String>) {
        private val nodes =
            grid.flatMapIndexed { y, row ->
                row.mapIndexedNotNull { x, char -> Point(x, y) to if (char == '#') INFECTED else CLEAN }
            }.toMap().toMutableMap()

        private var node = Point(grid.size / 2, grid.size / 2)
        private var direction = UP

        var infections = 0
            private set

        fun simpleRun() = doRun {
            when (node.state) {
                INFECTED -> direction.turn(RIGHT) to CLEAN
                else -> direction.turn(LEFT) to INFECTED
            }
        }

        fun advancedRun() = doRun {
            when (node.state) {
                CLEAN -> direction.turn(LEFT) to WEAKENED
                WEAKENED -> direction to INFECTED
                INFECTED -> direction.turn(RIGHT) to FLAGGED
                FLAGGED -> direction.reverse() to CLEAN
            }
        }

        private inline fun doRun(turn: Cluster.() -> Pair<Direction, State>) {
            val (goto, state) = turn()
            direction = goto
            node.state = state
            node += direction
            if (state == INFECTED) {
                infections++
            }
        }

        private var Point.state
            get() = nodes.getOrPut(this) { CLEAN }
            set(state) { nodes[this] = state }

        private enum class State { CLEAN, WEAKENED, INFECTED, FLAGGED }

        private fun Direction.reverse() = when (this) {
            UP -> DOWN
            DOWN -> UP
            LEFT -> RIGHT
            RIGHT -> LEFT
        }

        private fun Direction.turn(to: Direction) = when (this to to) {
            UP to RIGHT -> RIGHT
            RIGHT to RIGHT -> DOWN
            DOWN to RIGHT -> LEFT
            LEFT to RIGHT -> UP
            UP to LEFT -> LEFT
            RIGHT to LEFT -> UP
            DOWN to LEFT -> RIGHT
            LEFT to LEFT -> DOWN
            else -> error("Direction turn to '$to' is not supported.")
        }
    }
}
