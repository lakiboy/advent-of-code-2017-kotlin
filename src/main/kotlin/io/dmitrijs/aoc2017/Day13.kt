package io.dmitrijs.aoc2017

class Day13(input: List<String>) {
    private val firewall = input.associate {
        it.substringBefore(": ").toInt() to it.substringAfter(": ").toInt()
    }

    fun puzzle1() = firewall.keys.filter { catches(it) }.sumOf { firewall.getValue(it) * it }

    fun puzzle2(): Int {
        var offset = 0

        while (firewall.keys.any { catches(it, offset) }) {
            offset++
        }

        return offset
    }

    private fun catches(cursor: Int, offset: Int = 0) =
        (cursor + offset) % (firewall.getValue(cursor) * 2 - 2) == 0
}
