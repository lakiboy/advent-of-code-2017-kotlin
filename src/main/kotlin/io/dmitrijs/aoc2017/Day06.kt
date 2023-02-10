package io.dmitrijs.aoc2017

class Day06(input: String) {
    private val numbers = input.split("""\s""".toRegex()).map(String::toInt)
    private val distros = getDistributions()

    fun puzzle1() = distros.first

    fun puzzle2() = distros.second

    private fun getDistributions(): Pair<Int, Int> {
        var order = 0
        val blocks = numbers.toMutableList()
        val distros = hashMapOf<String, Int>()

        do {
            val (start, value) = blocks.withIndex().maxBy { (_, num) -> num }

            distros[blocks.toString()] = order++

            // Distribute
            blocks[start] = 0
            value.distribute(blocks.size).forEachIndexed { index, distribution ->
                blocks[(start + index + 1) % blocks.size] += distribution
            }
        } while (blocks.toString() !in distros)

        return distros.size to distros.size - distros.getValue(blocks.toString())
    }

    private fun Int.distribute(size: Int): List<Int> {
        val full = this / size
        val rem = this % size

        return List(size) { full + if (it < rem) 1 else 0 }
    }
}
