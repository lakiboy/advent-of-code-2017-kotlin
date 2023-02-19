package io.dmitrijs.aoc2017

class Day14(private val input: String) {
    fun puzzle1() =
        input.toGrid().sumOf { hash ->
            hash.chunked(7).sumOf { hex ->
                hex.toInt(16).countOneBits()
            }
        }

    fun puzzle2(): Int {
        var blocks = 0
        val points = input.toGrid().flatMapIndexed { y, line ->
            line.toBin().withIndex().fold(mutableSetOf<Point>()) { points, (x, char) ->
                points.apply {
                    if (char == '1') {
                        add(Point(x, y))
                    }
                }
            }
        }.toMutableSet()

        while (points.isNotEmpty()) {
            points.removeAll(extractBlock(points))
            blocks++
        }

        return blocks
    }

    private fun extractBlock(points: Set<Point>): Set<Point> {
        val start = points.first()
        val queue = ArrayDeque(listOf(start))
        val block = hashSetOf(start)

        while (queue.isNotEmpty()) {
            queue.removeFirst()
                .orthogonalNeighbours()
                .filter { it in points && it !in block }
                .let { neighbours ->
                    queue.addAll(neighbours)
                    block.addAll(neighbours)
                }
        }

        return block
    }

    private fun String.toGrid() = (0 until 128).map { knotHash("$this-$it") }

    private fun String.toBin() = toBigInteger(16).toString(2).padStart(128, '0')
}
