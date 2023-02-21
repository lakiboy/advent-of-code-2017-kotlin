package io.dmitrijs.aoc2017

class Day18(input: List<String>) {
    private val expressions = input.map { Expr.of(it) }
    private val channel: Map<Int, MutableList<Long>> = buildMap {
        put(0, mutableListOf())
        put(1, mutableListOf())
    }

    fun puzzle1() = Program().recoverFrequency()

    fun puzzle2(): Int {
        val program0 = Program(processId = 0)
        val program1 = Program(processId = 1)

        do {
            program0.runAndWait(program1)
            program1.runAndWait(program0)
        } while (program0.idle || program1.idle)

        return program1.sentPackets
    }

    private inner class Program(private val processId: Int = 0) {
        private val table = hashMapOf<String, Long>()
        private var cursor = 0

        val idle get() = channel.getValue(processId).isNotEmpty()

        var sentPackets = 0
            private set

        // Part II
        fun runAndWait(other: Program) {
            do {
                val expr = expressions[cursor]
                val next = cursor + 1
                cursor = when (expr.op) {
                    // snd a
                    "snd" -> next.also { other.produce(expr.value1) }.also { sentPackets++ }
                    // rcv a
                    "rcv" -> if (idle) next.also { table[expr.operand1] = consume() } else return
                    // jgz a -2
                    "jgz" -> if (expr.value1 > 0) cursor + expr.value2.toInt() else next
                    // set/add/mul/mod a 5
                    else -> next.also { expr.eval() }
                }
            } while (cursor < expressions.size)
        }

        // Part I
        fun recoverFrequency(): Long {
            var snd = -1L
            var cur = 0
            do {
                val expr = expressions[cur]
                val next = cur + 1
                cur = when (expr.op) {
                    // snd a
                    "snd" -> next.also { snd = expr.value1 }
                    // rcv a
                    "rcv" -> if (expr.value1 == 0L) next else EXIT
                    // jgz a -2
                    "jgz" -> if (expr.value1 > 0) cur + expr.value2.toInt() else next
                    // set/add/mul/mod a 5
                    else -> next.also { expr.eval() }
                }
            } while (cur != EXIT)

            return snd
        }

        private fun consume() = channel.getValue(processId).removeFirst()

        private fun produce(value: Long) = channel.getValue(processId).add(value)

        // Updated for part II.
        private val Expr.value1 get() = table.getOrElse(operand1) {
            operand1.toLongOrNull() ?: if (operand1 == "p") processId.toLong() else 0L
        }

        private val Expr.value2 get() = table.getOrElse(operand2) { operand2.toLong() }

        private fun Expr.eval() = when (op) {
            "set" -> table[operand1] = value2
            "add" -> table[operand1] = value1 + value2
            "mul" -> table[operand1] = value1 * value2
            "mod" -> table[operand1] = value1 % value2
            else -> error("Invalid operation '$op'.")
        }
    }

    private data class Expr(val op: String, val operand1: String, val operand2: String) {
        companion object {
            fun of(input: String) = input.split(" ").let { parts ->
                Expr(parts[0], parts[1], parts.getOrNull(2) ?: "")
            }
        }
    }

    companion object {
        private const val EXIT = -1
    }
}
