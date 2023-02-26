package io.dmitrijs.aoc2017

class Day23(private val input: List<String>) {
    fun puzzle1() = Program().apply { exec() }.mul

    fun puzzle2() = Program(mapOf('a' to 1)).apply { debug() }.result

    private inner class Program(defaults: Map<Char, Int> = emptyMap()) {
        private val env = (('a'..'h').associateWith { 0 } + defaults).toMutableMap()
        private var pos = 0
        var mul = 0
            private set

        val result get() = env.getValue('h')

        fun debug() {
            var iter = 0
            do {
                eval()
                println(env)
            } while (iter++ < 100)
        }

        fun exec() {
            do {
                eval()
            } while (pos < input.size)
        }

        private fun eval() {
            val (cmd, operand1, operand2) = input[pos].split(" ")
            val reg = operand1.first()
            when (cmd) {
                "set" -> reg.value = operand2.value
                "sub" -> reg.value -= operand2.value
                "mul" -> reg.value *= operand2.value.also { mul++ }
                "jnz" -> if (operand1.value != 0) pos += operand2.value - 1
                else -> error("Command '$cmd' is not supported.")
            }
            pos++
        }

        private var Char.value
            get() = env.getValue(this)
            set(value) { env[this] = value }

        private val String.value get() = env[first()] ?: toInt()
    }
}
