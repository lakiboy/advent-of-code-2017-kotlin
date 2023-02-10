package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 6")
internal class Day06Test {
    private val problemInput = Resources.resourceAsText("day06")
    private val exampleInput = "0 2 7 0"

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(5, Day06(exampleInput).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(5_042, Day06(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            assertEquals(4, Day06(exampleInput).puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals(1_086, Day06(problemInput).puzzle2())
        }
    }
}
