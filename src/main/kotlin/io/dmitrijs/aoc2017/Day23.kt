package io.dmitrijs.aoc2017

class Day23(private val input: List<String>) {
    fun puzzle1() = Program().apply { exec() }.mul

    // b = 109900
    // c = 126900
    // do {
    //     f = 1
    //     d = 2
    //     do {
    //         e = 2
    //         do {
    //             g = d * e - b
    //             if (g == 0) f = 0
    //             e++
    //         } while (e != b && f != 0)
    //         d++
    //     } while (d != b && f != 0)
    //     if (f == 0) h++
    //     if (b == c) break else b += 17
    // } while (true)
    fun puzzle2() = (109900..126900 step 17).count { it.composite }

    private val Int.composite get() = (2 until this).any { this % it == 0 }

    private inner class Program {
        private val env = (('a'..'h').associateWith { 0 }).toMutableMap()
        var mul = 0
            private set

        fun exec() {
            var pos = 0
            do {
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
            } while (pos < input.size)
        }

        private var Char.value
            get() = env.getValue(this)
            set(value) { env[this] = value }

        private val String.value get() = env[first()] ?: toInt()
    }
}
