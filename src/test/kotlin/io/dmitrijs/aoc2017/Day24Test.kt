package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 24")
internal class Day24Test {
    private val problemInput = Resources.resourceAsLines("day24")
    private val exampleInput = """
        0/2
        2/2
        2/3
        3/4
        3/5
        0/1
        10/1
        9/10
    """.trimIndent().lines()

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(31, Day24(exampleInput).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(585, Day24(problemInput).puzzle1())
        }
    }
}
