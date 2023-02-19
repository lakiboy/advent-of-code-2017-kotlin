package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 15")
internal class Day15Test {
    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(588, Day15(65, 8_921).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(597, Day15(516, 190).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            assertEquals(309, Day15(65, 8_921).puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals(303, Day15(516, 190).puzzle2())
        }
    }
}
