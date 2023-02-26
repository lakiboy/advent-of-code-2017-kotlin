package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 22")
internal class Day22Test {
    private val problemInput = Resources.resourceAsLines("day22")
    private val exampleInput = """
        ..#
        #..
        ...
    """.trimIndent().lines()

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(5_587, Day22(exampleInput).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(5_447, Day22(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            assertEquals(2_511_944, Day22(exampleInput).puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals(2_511_705, Day22(problemInput).puzzle2())
        }
    }
}
