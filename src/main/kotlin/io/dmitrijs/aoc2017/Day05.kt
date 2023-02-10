package io.dmitrijs.aoc2017

class Day05(input: List<String>) {
    private val numbers = input.map { it.toInt() }
    private val indices = numbers.indices

    fun puzzle1() = puzzle()

    fun puzzle2() = puzzle(decrease = true)

    private fun puzzle(decrease: Boolean = false): Int {
        val items = numbers.toMutableList()
        var index = 0
        var steps = 0

        do {
            steps++
            index += if (items[index] >= 3 && decrease) items[index]-- else items[index]++
        } while (index in indices)

        return steps
    }
}
