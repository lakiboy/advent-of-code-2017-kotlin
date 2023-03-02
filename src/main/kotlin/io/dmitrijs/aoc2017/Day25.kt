package io.dmitrijs.aoc2017

class Day25(input: String) {
    private val start: Char
    private val steps: Int
    private val states: Map<Char, State>

    init {
        parseInt(input).apply {
            start = first
            steps = second
            states = third
        }
    }

    fun puzzle1(): Int {
        val tape = hashMapOf<Int, Int>()
        var cursor = 0
        var current = start

        repeat(steps) {
            states.getValue(current)(tape[cursor] ?: 0).let { (state, value, diff) ->
                tape[cursor] = value
                current = state
                cursor += diff
            }
        }

        return tape.values.sum()
    }

    private data class State(val id: Char, private val actionA: Action, private val actionB: Action) {
        operator fun invoke(value: Int) = if (value == 0) actionA else actionB
    }

    private data class Action(val state: Char, val value: Int, val diff: Int)

    private fun parseInt(input: String): Triple<Char, Int, Map<Char, State>> {
        val blocks = input.split("\n\n")
        val (line1, line2) = blocks.first().lines()

        val state = line1.substringAfterLast(" ").first()
        val steps = line2.split(" ").dropLast(1).last().toInt()
        val states = blocks.drop(1).map { it.toState() }.associateBy { it.id }

        return Triple(state, steps, states)
    }

    private fun String.toState(): State {
        val lines = lines()
        val id = lines.first().substringAfterLast(" ").first()

        val (actionA, actionB) = lines.drop(1).chunked(4) { action ->
            val (line1, line2, line3) = action.drop(1).map { it.trimEnd('.') }

            val state = line3.substringAfterLast(" ").first()
            val value = line1.substringAfterLast(" ").toInt()
            val diff = if (line2.substringAfterLast(" ") == "right") 1 else -1

            Action(state, value, diff)
        }

        return State(id, actionA, actionB)
    }
}
