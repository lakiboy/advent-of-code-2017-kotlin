package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 17")
internal class Day17Test {
    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(638, Day17(3).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(1_282, Day17(335).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            assertEquals(844, Day17(335).puzzle2(2017))
        }

        @Test
        fun `solves problem`() {
            assertEquals(27_650_600, Day17(335).puzzle2())
        }
    }
}
