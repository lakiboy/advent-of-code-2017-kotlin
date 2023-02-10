package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 4")
internal class Day04Test {
    private val problemInput = Resources.resourceAsLines("day04")

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            val exampleInput = """
                aa bb cc dd ee
                aa bb cc dd aa
                aa bb cc dd aaa
            """.trimIndent().lines()

            assertEquals(2, Day04(exampleInput).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(386, Day04(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            val exampleInput = """
                abcde fghij
                abcde xyz ecdab
                a ab abc abd abf abj
                iiii oiii ooii oooi oooo
                oiii ioii iioi iiio
            """.trimIndent().lines()

            assertEquals(3, Day04(exampleInput).puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals(208, Day04(problemInput).puzzle2())
        }
    }
}
