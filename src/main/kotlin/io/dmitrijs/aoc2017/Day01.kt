package io.dmitrijs.aoc2017

class Day01(private val input: String) {
    fun puzzle1(): Int {
        val last = if (input.first() == input.last()) input.first().digitToInt() else 0

        return input.zipWithNext { a, b -> if (a == b) a.digitToInt() else 0 }.sum() + last
    }

    fun puzzle2(): Int {
        val half = input.length / 2

        return (0 until half).sumOf { index ->
            if (input[index] == input[index + half]) input[index].digitToInt() * 2 else 0
        }
    }
}
