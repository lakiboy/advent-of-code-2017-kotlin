package io.dmitrijs.aoc2017

import java.io.File
import java.net.URI

internal object Resources {
    fun resourceAsText(fileName: String): String = File(fileName.toURI()).readText().trimEnd()

    fun resourceAsLines(fileName: String): List<String> = File(fileName.toURI()).readLines()

    fun resourceAsListOfInt(fileName: String) = resourceAsLines(fileName).map(String::toInt)

    fun resourceAsListOfLong(fileName: String) = resourceAsLines(fileName).map(String::toLong)

    private fun String.toURI(): URI =
        Resources.javaClass.getResource("/$this.txt")
            ?.toURI()
            ?: error("Cannot find resource: $this")
}
