package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 23")
internal class Day23Test {
    private val problemInput = Resources.resourceAsLines("day23")

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves problem`() {
            assertEquals(9_409, Day23(problemInput).puzzle1())
        }
    }

//    @Nested
//    @DisplayName("Puzzle 2")
//    inner class Puzzle2 {
//        @Test
//        fun `solves problem`() {
//            assertEquals(9_409, Day23(problemInput).puzzle2())
//        }
//    }
}
