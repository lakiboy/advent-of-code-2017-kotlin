package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 18")
internal class Day18Test {
    private val problemInput = Resources.resourceAsLines("day18")
    private val exampleInput = """
        set a 1
        add a 2
        mul a a
        mod a 5
        snd a
        set a 0
        rcv a
        jgz a -1
        set a 1
        jgz a -2
    """.trimIndent().lines()

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(4L, Day18(exampleInput).puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(4_601L, Day18(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            assertEquals(6_858, Day18(problemInput).puzzle2())
        }
    }
}
