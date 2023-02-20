package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 16")
internal class Day16Test {
    private val problemInput = Resources.resourceAsText("day16")
    private val exampleInput = "s1,x3/4,pe/b"

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals("baedc", Day16(exampleInput, 5).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals("namdgkbhifpceloj", Day16(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves problem`() {
            assertEquals("ibmchklnofjpdeag", Day16(problemInput).puzzle2())
        }
    }
}
