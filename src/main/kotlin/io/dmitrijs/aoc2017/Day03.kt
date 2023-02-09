package io.dmitrijs.aoc2017

class Day03(private val num: Int) {
    private val target = Point(0, 0)

    fun puzzle1(): Int {
        if (num == 1) {
            return 0
        }

        val (step, side) = generateSequence(1 to 1) { (step, side) ->
            (step + 1 to side + 2).takeIf { (_, side) -> num >= side * side }
        }.last()

        val corner = Point(step - 1, step - 1)
        val square = side * side

        return framingMoves(side + 1)
            .take(num - square)
            .fold(corner) { point, direction -> (point + direction) }
            .distanceTo(target)
    }

    private fun framingMoves(side: Int) = sequence {
        yield(Direction.RIGHT)
        (0 until side - 1).map { yield(Direction.UP) }
        (0 until side).map { yield(Direction.LEFT) }
        (0 until side).map { yield(Direction.DOWN) }
        (0 until side).map { yield(Direction.RIGHT) }
    }
}
