package gg.vance.day1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Tests {
    val day1 = Day1()

    @Test
    fun part1() {
        assertEquals(68775, day1.part1())
    }

    @Test
    fun part2() {
        assertEquals(202585, day1.part2())
    }
}
