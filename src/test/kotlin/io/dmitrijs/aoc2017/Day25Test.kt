package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 25")
internal class Day25Test {
    private val problemInput = Resources.resourceAsText("day25")
    private val exampleInput = """
        Begin in state A.
        Perform a diagnostic checksum after 6 steps.
        
        In state A:
          If the current value is 0:
            - Write the value 1.
            - Move one slot to the right.
            - Continue with state B.
          If the current value is 1:
            - Write the value 0.
            - Move one slot to the left.
            - Continue with state B.
        
        In state B:
          If the current value is 0:
            - Write the value 1.
            - Move one slot to the left.
            - Continue with state A.
          If the current value is 1:
            - Write the value 1.
            - Move one slot to the right.
            - Continue with state A.
    """.trimIndent()

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves examples`() {
            assertEquals(3, Day25(exampleInput).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(4_217, Day25(problemInput).puzzle1())
        }
    }
}
