package io.dmitrijs.aoc2017

import io.dmitrijs.aoc2017.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 1")
internal class Day01Test {
    private val problemInput = resourceAsText("day01")

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(3, Day01("1122").puzzle1())
            assertEquals(4, Day01("1111").puzzle1())
            assertEquals(0, Day01("1234").puzzle1())
            assertEquals(9, Day01("91212129").puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(1_144, Day01(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            assertEquals(6, Day01("1212").puzzle2())
            assertEquals(0, Day01("1221").puzzle2())
            assertEquals(4, Day01("123425").puzzle2())
            assertEquals(12, Day01("123123").puzzle2())
            assertEquals(4, Day01("12131415").puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals(1_194, Day01(problemInput).puzzle2())
        }
    }
}
