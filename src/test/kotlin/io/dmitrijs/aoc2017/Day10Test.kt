package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 10")
internal class Day10Test {
    private val problemInput = Resources.resourceAsText("day10")

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(12, Day10("3,4,1,5").puzzle1(5))
        }

        @Test
        fun `solves problem`() {
            assertEquals(23_715, Day10(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            assertEquals("a2582a3a0e66e6e86e3812dcb672a272", Day10("").puzzle2())
            assertEquals("33efeb34ea91902bb2f59c9920caa6cd", Day10("AoC 2017").puzzle2())
            assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", Day10("1,2,3").puzzle2())
            assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", Day10("1,2,4").puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals("541dc3180fd4b72881e39cf925a50253", Day10(problemInput).puzzle2())
        }
    }
}
