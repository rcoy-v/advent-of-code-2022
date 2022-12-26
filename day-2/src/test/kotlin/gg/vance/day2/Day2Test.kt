package gg.vance.day2

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class Day2Test {
    @ParameterizedTest
    @CsvSource("/example-input,15", "/puzzle-input,11475")
    fun part1(inputPath: String, expected: Int) {
        val puzzle = Day2(inputPath)

        assertEquals(expected, puzzle.part1())
    }

    @ParameterizedTest
    @CsvSource("/example-input,12", "/puzzle-input,16862")
    fun part2(inputPath: String, expected: Int) {
        val puzzle = Day2(inputPath)

        assertEquals(expected, puzzle.part2())
    }
}
