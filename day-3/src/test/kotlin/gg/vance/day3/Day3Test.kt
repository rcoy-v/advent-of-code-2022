package gg.vance.day3

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class Day3Test {
    @ParameterizedTest
    @CsvSource("/example-input,157", "/puzzle-input,7848")
    fun part1(inputPath: String, expected: Int) {
        val puzzle = Day3(inputPath)

        assertEquals(expected, puzzle.part1())
    }
    @ParameterizedTest
    @CsvSource("/example-input,70", "/puzzle-input,2616")
    fun part2(inputPath: String, expected: Int) {
        val puzzle = Day3(inputPath)

        assertEquals(expected, puzzle.part2())
    }
}