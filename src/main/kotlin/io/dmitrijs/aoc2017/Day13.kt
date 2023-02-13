package io.dmitrijs.aoc2017

class Day13(input: List<String>) {
    private val firewall = input.associate {
        it.substringBefore(": ").toInt() to it.substringAfter(": ").toInt()
    }
    private val layers = 0..firewall.maxOf { it.key } + 1

    fun puzzle1() = layers.filter { firewall.catches(it) }.sumOf { firewall.getValue(it) * it }

    fun puzzle2(): Int {
        var offset = 0

        while (layers.any { firewall.catches(it, offset) }) {
            offset++
        }

        return offset
    }

    private fun Map<Int, Int>.catches(cursor: Int, offset: Int = 0) =
        cursor in this && (cursor + offset) % (firewall.getValue(cursor) * 2 - 2) == 0
}
