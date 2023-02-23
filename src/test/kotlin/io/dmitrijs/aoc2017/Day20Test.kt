package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 20")
internal class Day20Test {
    private val problemInput = Resources.resourceAsLines("day20")

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            val exampleInput = """
                p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>
                p=<4,0,0>, v=<0,0,0>, a=<-2,0,0>
            """.trimIndent().lines()

            assertEquals(0, Day20(exampleInput).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(91, Day20(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            val exampleInput = """
                p=<-6,0,0>, v=<3,0,0>, a=<0,0,0>
                p=<-4,0,0>, v=<2,0,0>, a=<0,0,0>
                p=<-2,0,0>, v=<1,0,0>, a=<0,0,0>
                p=<3,0,0>, v=<-1,0,0>, a=<0,0,0>
            """.trimIndent().lines()

            assertEquals(1, Day20(exampleInput).puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals(567, Day20(problemInput).puzzle2())
        }
    }
}
