package io.dmitrijs.aoc2017

class Day03(private val num: Int) {
    private val start = Point(0, 0)

    fun puzzle1(): Int {
        if (num == 1) {
            return 0
        }

        val side = generateSequence(1) { side ->
            (side + 2).takeIf { num >= it * it }
        }.last()

        val corner = Point(side / 2, side / 2)
        val square = side * side

        return framingMoves(side + 1)
            .take(num - square)
            .fold(corner) { point, direction -> (point + direction) }
            .distanceTo(start)
    }

    fun puzzle2(): Int {
        var cursor = start
        val spiral = hashMapOf(start to 1)

        for (side in generateSequence(1) { it + 2 }) {
            for (direction in framingMoves(side)) {
                cursor += direction
                spiral[cursor] = cursor.neighbours().sumOf { spiral.getOrDefault(it, 0) }.also { sum ->
                    if (sum > num) {
                        return sum
                    }
                }
            }
        }

        return -1
    }

    private fun framingMoves(side: Int) = sequence {
        yield(Direction.RIGHT)
        (0 until side - 1).map { yield(Direction.UP) }
        (0 until side).map { yield(Direction.LEFT) }
        (0 until side).map { yield(Direction.DOWN) }
        (0 until side).map { yield(Direction.RIGHT) }
    }
}
