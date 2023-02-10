package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 5")
internal class Day05Test {
    private val problemInput = Resources.resourceAsLines("day05")
    private val exampleInput = """
        0
        3
        0
        1
        -3
    """.trimIndent().lines()

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(5, Day05(exampleInput).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(373_160, Day05(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            assertEquals(10, Day05(exampleInput).puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals(26_395_586, Day05(problemInput).puzzle2())
        }
    }
}
