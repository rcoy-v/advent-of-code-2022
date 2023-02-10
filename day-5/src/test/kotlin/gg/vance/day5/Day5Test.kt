package gg.vance.day5

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class Day5Test {
    @ParameterizedTest
    @CsvSource("/example-input,CMZ", "/puzzle-input,JCMHLVGMG")
    fun part1(inputPath: String, expected: String) {
        val puzzle = Day5(inputPath)

        assertEquals(expected, puzzle.part1())
    }

    @ParameterizedTest
    @CsvSource("/example-input,MCD", "/puzzle-input,LVMRWSSPZ")
    fun part2(inputPath: String, expected: String) {
        val puzzle = Day5(inputPath)

        assertEquals(expected, puzzle.part2())
    }
}
