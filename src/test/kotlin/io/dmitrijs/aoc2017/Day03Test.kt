package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 3")
internal class Day03Test {
    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(0, Day03(1).puzzle1())
            assertEquals(3, Day03(12).puzzle1())
            assertEquals(2, Day03(23).puzzle1())
            assertEquals(31, Day03(1024).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(552, Day03(325_489).puzzle1())
        }
    }
}
