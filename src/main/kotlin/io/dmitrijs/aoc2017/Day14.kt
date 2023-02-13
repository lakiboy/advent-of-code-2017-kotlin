package io.dmitrijs.aoc2017

class Day14(private val input: String) {
    fun puzzle1() =
        (0 until 128).map { knotHash("$input-$it") }.sumOf { hash ->
            hash.chunked(2).sumOf { hex ->
                hex.toInt(16).countOneBits()
            }
        }
}
