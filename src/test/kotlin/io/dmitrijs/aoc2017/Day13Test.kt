package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 13")
internal class Day13Test {
    private val problemInput = Resources.resourceAsLines("day13")
    private val exampleInput = """
        0: 3
        1: 2
        4: 4
        6: 4
    """.trimIndent().lines()

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(24, Day13(exampleInput).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(1_476, Day13(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            assertEquals(10, Day13(exampleInput).puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals(3_937_334, Day13(problemInput).puzzle2())
        }
    }
}
