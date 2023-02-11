package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 12")
internal class Day12Test {
    private val problemInput = Resources.resourceAsLines("day12")
    private val exampleInput = """
        0 <-> 2
        1 <-> 1
        2 <-> 0, 3, 4
        3 <-> 2, 4
        4 <-> 2, 3, 6
        5 <-> 6
        6 <-> 4, 5
    """.trimIndent().lines()

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(6, Day12(exampleInput).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(134, Day12(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            assertEquals(2, Day12(exampleInput).puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals(193, Day12(problemInput).puzzle2())
        }
    }
}
