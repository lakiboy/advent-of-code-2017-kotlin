package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 11")
internal class Day11Test {
    private val problemInput = Resources.resourceAsText("day11")

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(3, Day11("ne,ne,ne").puzzle1())
            assertEquals(0, Day11("ne,ne,sw,sw").puzzle1())
            assertEquals(2, Day11("ne,ne,s,s").puzzle1())
            assertEquals(3, Day11("se,sw,se,sw,sw").puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(720, Day11(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves problem`() {
            assertEquals(1_485, Day11(problemInput).puzzle2())
        }
    }
}
