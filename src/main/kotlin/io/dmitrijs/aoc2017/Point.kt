package io.dmitrijs.aoc2017

import kotlin.math.absoluteValue

data class Point(val x: Int, val y: Int) {
    fun distanceTo(other: Point) = (x - other.x).absoluteValue + (y - other.y).absoluteValue

    operator fun plus(other: Point) = copy(x = x + other.x, y = y + other.y)

    operator fun plus(other: Direction) = plus(other.move)
}

enum class Direction(val move: Point) {
    UP(move = Point(0, -1)),
    DOWN(move = Point(0, 1)),
    LEFT(move = Point(-1, 0)),
    RIGHT(move = Point(1, 0));

    companion object
}
