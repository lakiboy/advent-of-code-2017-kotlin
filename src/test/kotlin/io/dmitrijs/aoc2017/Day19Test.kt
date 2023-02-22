package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 19")
internal class Day19Test {
    private val problemInput = Resources.resourceAsLines("day19")
    private val exampleInput = """
             |          
             |  +--+    
             A  |  C    
         F---|----E|--+ 
             |  |  |  D 
             +B-+  +--+
    """.trimIndent().lines()

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals("ABCDEF", Day19(exampleInput).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals("ITSZCJNMUO", Day19(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            assertEquals(38, Day19(exampleInput).puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals(17_420, Day19(problemInput).puzzle2())
        }
    }
}
