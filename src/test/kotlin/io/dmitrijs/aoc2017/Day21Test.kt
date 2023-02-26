package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 21")
internal class Day21Test {
    private val problemInput = Resources.resourceAsLines("day21")

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves problem`() {
            assertEquals(117, Day21(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves problem`() {
            assertEquals(2_026_963, Day21(problemInput).puzzle2())
        }
    }
}
