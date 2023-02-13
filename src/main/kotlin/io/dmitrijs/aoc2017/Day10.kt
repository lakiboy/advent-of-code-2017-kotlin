package io.dmitrijs.aoc2017

fun knotHash(value: String) =
    (value.map { it.code } + listOf(17, 31, 73, 47, 23))
        .encode(rounds = 64)
        .chunked(16) { chunk -> chunk.reduce { a, b -> a xor b } }
        .joinToString("") { "%02x".format(it) }

class Day10(private val input: String) {
    fun puzzle1(size: Int = 256) =
        input
            .split(",")
            .map { it.toInt() }
            .encode(size)
            .take(2)
            .reduce { a, b -> a * b }

    fun puzzle2() = knotHash(input)
}

private fun List<Int>.encode(size: Int = 256, rounds: Int = 1): List<Int> {
    val items = (0 until size).toMutableList()
    var index = 0
    var skip = 0

    repeat(rounds) {
        forEach { len ->
            items.reverseSubList(index, len)
            index = (index + len + skip++) % items.size
        }
    }

    return items
}

private fun MutableList<Int>.reverseSubList(start: Int, len: Int) =
    repeat(len / 2) { pos ->
        val aIndex = (start + pos) % size
        val bIndex = (start + len - 1 - pos) % size
        this[aIndex] = this[bIndex].also { this[bIndex] = this[aIndex] }
    }
