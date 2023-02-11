package io.dmitrijs.aoc2017

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Day 9")
internal class Day09Test {
    private val problemInput = Resources.resourceAsText("day09")

    @Nested
    @DisplayName("Puzzle 1")
    inner class Puzzle1 {
        @Test
        fun `solves example`() {
            assertEquals(1, Day09("""{}""").puzzle1())
            assertEquals(6, Day09("""{{{}}}""").puzzle1())
            assertEquals(5, Day09("""{{},{}}""").puzzle1())
            assertEquals(16, Day09("""{{{},{},{{}}}}""").puzzle1())
            assertEquals(1, Day09("""{<a>,<a>,<a>,<a>}""").puzzle1())
            assertEquals(9, Day09("""{{<ab>},{<ab>},{<ab>},{<ab>}}""").puzzle1())
            assertEquals(9, Day09("""{{<!!>},{<!!>},{<!!>},{<!!>}}""").puzzle1())
            assertEquals(3, Day09("""{{<a!>},{<a!>},{<a!>},{<ab>}}""").puzzle1())
        }

        @Test
        fun `solves problem`() {
            assertEquals(9_662, Day09(problemInput).puzzle1())
        }
    }

    @Nested
    @DisplayName("Puzzle 2")
    inner class Puzzle2 {
        @Test
        fun `solves example`() {
            assertEquals(0, Day09("""<>""").puzzle2())
            assertEquals(17, Day09("""<random characters>""").puzzle2())
            assertEquals(3, Day09("""<<<<>""").puzzle2())
            assertEquals(2, Day09("""<{!>}>""").puzzle2())
            assertEquals(0, Day09("""<!!>""").puzzle2())
            assertEquals(0, Day09("""<!!!>>""").puzzle2())
            assertEquals(10, Day09("""<{o"i!a,<{i<a>""").puzzle2())
        }

        @Test
        fun `solves problem`() {
            assertEquals(4_903, Day09(problemInput).puzzle2())
        }
    }
}
