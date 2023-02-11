package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 8")
internal class Day08Test {
    private val problemInput = Resources.resourceAsLines("day08")
    private val exampleInput = """
        b inc 5 if a > 1
        a inc 1 if b < 5
        c dec -10 if a >= 1
        c inc -20 if c == 10
    """.trimIndent().lines()

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(1, Day08(exampleInput).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(4_567, Day08(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            assertEquals(10, Day08(exampleInput).puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals(5_636, Day08(problemInput).puzzle2())
        }
    }
}
