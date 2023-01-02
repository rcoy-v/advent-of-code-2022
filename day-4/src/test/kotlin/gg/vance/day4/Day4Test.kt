package gg.vance.day4

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class Day4Test {
    @ParameterizedTest
    @CsvSource("/example-input,2", "/puzzle-input,459")
    fun part1(inputPath: String, expected: Int) {
        val puzzle = Day4(inputPath)

        assertEquals(expected, puzzle.part1())
    }

    @ParameterizedTest
    @CsvSource("/example-input,4", "/puzzle-input,779")
    fun part2(inputPath: String, expected: Int) {
        val puzzle = Day4(inputPath)

        assertEquals(expected, puzzle.part2())
    }
}
