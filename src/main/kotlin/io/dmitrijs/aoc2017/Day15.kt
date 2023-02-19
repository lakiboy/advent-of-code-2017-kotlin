package io.dmitrijs.aoc2017

class Day15(seedA: Int, seedB: Int) {
    private val genA = generate(seedA, 16_807L)
    private val genB = generate(seedB, 48_271L)

    fun puzzle1() = genA.zip(genB).take(40_000_000).count { (a, b) -> a == b }

    fun puzzle2() =
        genA.filter { it % 4 == 0 }
            .zip(genB.filter { it % 8 == 0 })
            .take(5_000_000)
            .count { (a, b) -> a == b }

    private fun generate(seed: Int, factor: Long): Sequence<Short> {
        var next = seed.toLong()

        // Could get bitwise math only a little faster.
        return generateSequence { (next * factor % Int.MAX_VALUE).also { next = it }.toShort() }
    }
}
