package io.dmitrijs.aoc2017

class Day09(private val input: String) {
    fun puzzle1(): Int {
        val stream = input
            .replace(Regex("""[^{}<>!]|!."""), "")
            .replace(Regex("""<.*?>"""), "")

        require(stream.count { it == '{' } == stream.count { it == '}' }) { "Invalid stream." }

        val queue = stream.toMutableList()
        var score = 0
        var depth = 0

        while (queue.isNotEmpty()) {
            when (queue.removeFirst()) {
                '{' -> depth++
                '}' -> score += depth--
            }
        }

        return score
    }

    fun puzzle2(): Int {
        val stream = input.replace(Regex("""!."""), "")

        return """<(.*?)>""".toRegex().findAll(stream).sumOf { it.groupValues[1].length }
    }
}
