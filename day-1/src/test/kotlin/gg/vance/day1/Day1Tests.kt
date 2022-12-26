package gg.vance.day1

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class Day1Tests {
    @ParameterizedTest
    @CsvSource("/example-input,24000", "/puzzle-input,68775")
    fun part1(inputPath: String, expected: Int) {
        val puzzle = Day1(inputPath)

        assertEquals(expected, puzzle.part1())
    }

    @ParameterizedTest
    @CsvSource("/example-input,45000", "/puzzle-input,202585")
    fun part2(inputPath: String, expected: Int) {
        val puzzle = Day1(inputPath)

        assertEquals(expected, puzzle.part2())
    }
}
