package io.dmitrijs.aoc2017

class Day04(private val input: List<String>) {
    fun puzzle1() = input.count { it == it.split(" ").distinct().joinToString(" ") }

    fun puzzle2() = input.count { line ->
        val words = line.split(" ")
        val pairs = words.flatMapIndexed { i, a ->
            words.mapIndexedNotNull { j, b -> if (i != j) a to b else null }
        }
        pairs.all { (a, b) -> a.toCharArray().sorted() != b.toCharArray().sorted() }
    }
}
