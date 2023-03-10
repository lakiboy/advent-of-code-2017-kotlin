package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 14")
internal class Day14Test {
    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(8_108, Day14("flqrgnkx").puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(8_316, Day14("ljoxqyyw").puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            assertEquals(1_242, Day14("flqrgnkx").puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals(1_074, Day14("ljoxqyyw").puzzle2())
        }
    }
}
