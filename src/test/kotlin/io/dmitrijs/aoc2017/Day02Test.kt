package io.dmitrijs.aoc2017

import io.dmitrijs.aoc2017.Resources.resourceAsLines
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 2")
internal class Day02Test {
    private val problemInput = resourceAsLines("day02")

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            val exampleInput = """
                5 1 9 5
                7 5 3
                2 4 6 8
            """.trimIndent().lines()

            assertEquals(18, Day02(exampleInput).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(51_139, Day02(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            val exampleInput = """
                5 9 2 8
                9 4 7 3
                3 8 6 5
            """.trimIndent().lines()

            assertEquals(9, Day02(exampleInput).puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals(272, Day02(problemInput).puzzle2())
        }
    }
}
