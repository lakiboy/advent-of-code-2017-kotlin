package io.dmitrijs.aoc2017

class Day02(input: List<String>) {
    private val numbers = input.map {
        it.split("""\s""".toRegex()).map(String::toInt)
    }

    fun puzzle1() = numbers.sumOf { it.max() - it.min() }

    fun puzzle2() = numbers.sumOf(::divisible)

    private fun divisible(numbers: List<Int>): Int {
        for (i in numbers) {
            for (j in numbers) {
                when {
                    i == j -> continue
                    i > j && i % j == 0 -> return i / j
                    j > i && j % i == 0 -> return j / i
                }
            }
        }

        return 0
    }
}
