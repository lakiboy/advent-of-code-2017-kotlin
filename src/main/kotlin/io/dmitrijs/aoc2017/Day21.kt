package io.dmitrijs.aoc2017

import kotlin.math.sqrt

class Day21(input: List<String>) {
    private val start = Matrix.of(".#./..#/###")
    private val rules = input.fold(mapOf<Matrix, Matrix>()) { acc, line ->
        val (source, target) = line.split(" => ").map { Matrix.of(it) }
        acc + source.variations().associateWith { target }
    }

    fun puzzle1() = solve(5)

    fun puzzle2() = solve(18)

    private fun solve(turns: Int) =
        (0 until turns).fold(start) { image, _ ->
            image.split().map { rules.getValue(it) }.join()
        }.onPixelsCount

    private fun List<Matrix>.join() = Matrix.of(this)

    private data class Matrix(private val pixels: List<String>) {
        private val size = pixels.size

        val onPixelsCount get() = pixels.sumOf { row ->
            row.count { it == '#' }
        }

        // 8 variations in total
        fun variations() = rotations() + flip().rotations()

        fun split(): List<Matrix> {
            val blockSize = if (size % 2 == 0) 2 else 3
            val blocks = size / blockSize

            return pixels.chunked(blockSize).flatMap { block ->
                (0 until blocks).map { num ->
                    copy(pixels = block.map { it.substring(blockSize * num, blockSize * (num + 1)) })
                }
            }
        }

        private fun rotations() = (0..3).fold(listOf(this)) { acc, _ -> acc + acc.last().rotate() }

        private fun flip() = Matrix(pixels.map { it.reversed() })

        private fun rotate() = Matrix(
            pixels.indices.map { y ->
                pixels.indices.joinToString("") { x -> pixels[x][size - 1 - y].toString() }
            }
        )

        override fun toString() = pixels.joinToString("\n")

        companion object {
            fun of(pattern: String) = Matrix(pattern.split("/"))

            fun of(matrices: List<Matrix>): Matrix {
                val rowsCount = sqrt(matrices.size.toFloat()).toInt()
                val blockSize = matrices.first().size

                val pixels = matrices.chunked(rowsCount).flatMap { row ->
                    (0 until blockSize).map { y ->
                        row.map { it.pixels[y] }.reduce { a, b -> a + b }
                    }
                }

                return Matrix(pixels)
            }
        }
    }
}
