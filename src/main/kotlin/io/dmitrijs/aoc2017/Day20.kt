package io.dmitrijs.aoc2017

import kotlin.math.absoluteValue

class Day20(input: List<String>) {
    private val particles = input.map { Particle.of(it) }

    fun puzzle1() = particles.withIndex().minBy { (_, particle) -> particle.a.distance }.index

    fun puzzle2(steps: Int = 100): Int {
        val items = particles.toMutableList()

        repeat(steps) {
            (0 until items.size).forEach { index -> items[index] = items[index].move() }
            items.groupBy { it.p }
                .filterValues { it.size > 1 }
                .forEach { (_, collisions) -> items.removeAll(collisions) }
        }

        return items.size
    }

    private val Point3d.distance get() = x.absoluteValue + y.absoluteValue + z.absoluteValue

    private data class Particle(val p: Point3d, val v: Point3d, val a: Point3d) {
        fun move() = copy(v = v + a, p = p + v + a)

        companion object {
            fun of(str: String): Particle {
                val (p, v, a) = str.split(", ").map { it.substring(3, it.length - 1) }

                return Particle(Point3d.of(p), Point3d.of(v), Point3d.of(a))
            }
        }
    }
}
