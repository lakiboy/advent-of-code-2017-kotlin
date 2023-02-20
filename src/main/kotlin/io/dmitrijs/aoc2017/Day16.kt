package io.dmitrijs.aoc2017

import io.dmitrijs.aoc2017.Day16.Move.Exchange
import io.dmitrijs.aoc2017.Day16.Move.Partner
import io.dmitrijs.aoc2017.Day16.Move.Spin

class Day16(input: String, size: Int = 16) {
    private val moves = input.split(",").map { Move.of(it) }
    private val range = (0 until size).map { (97 + it).toChar() }.joinToString("")

    fun puzzle1() = range.dance()

    fun puzzle2(): String {
        var index = 0
        val history = hashMapOf<String, Int>()
        var letters = range.dance()

        while (letters !in history) {
            history[letters] = index++
            letters = letters.dance()
        }

        val start = history.getValue(letters)
        val cycle = history.size - start
        val shift = ((1_000_000_000L - start) % cycle).toInt() - 1

        return history.filterValues { pos -> pos == shift }.keys.single()
    }

    private fun String.dance() = moves.fold(this) { str, move ->
        when (move) {
            is Spin -> str.spin(move.count)
            is Exchange -> str.swap(move.a, move.b)
            is Partner -> str.swap(move.a, move.b)
        }
    }

    private fun String.spin(count: Int) = substring(length - count) + substring(0, length - count)

    private fun String.swap(one: Int, two: Int) = swap(get(one), get(two))

    private fun String.swap(one: Char, two: Char) = replace(one, 'X').replace(two, one).replace('X', two)

    private sealed class Move {
        data class Spin(val count: Int) : Move()

        data class Exchange(val a: Int, val b: Int) : Move()

        data class Partner(val a: Char, val b: Char) : Move()

        companion object {
            fun of(move: String): Move {
                val dance = move.first()
                val pairs = move.substring(1)

                return when (dance) {
                    's' -> Spin(pairs.toInt())
                    'x' -> Exchange(pairs.substringBefore("/").toInt(), pairs.substringAfter("/").toInt())
                    'p' -> Partner(pairs.substringBefore("/").single(), pairs.substringAfter("/").single())
                    else -> error("Invalid dance '$dance'.")
                }
            }
        }
    }
}
