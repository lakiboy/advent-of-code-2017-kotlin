package io.dmitrijs.aoc2017

class Day17(private val size: Int) {
    fun puzzle1(): Int {
        var cursor = 0
        val buffer = mutableListOf(0)

        repeat(2017) { index ->
            cursor = (cursor + size) % buffer.size + 1
            buffer.add(cursor, index + 1)
        }

        return buffer[cursor + 1]
    }

    fun puzzle2(steps: Int = 50_000_000): Int {
        var cursor = 0
        var result = 0

        repeat(steps) { index ->
            cursor = (cursor + size) % (index + 1) + 1

            // Remember last value after zero.
            if (cursor == 1) {
                result = index + 1
            }
        }

        return result
    }
}
