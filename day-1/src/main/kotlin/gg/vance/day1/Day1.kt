package gg.vance.day1

class Day1 {
    private val elves = mutableListOf<Elf>()

    init {
        val input =
            this::class.java.getResourceAsStream("/puzzle-input") ?: throw Exception("puzzle input is empty")

        var food = mutableListOf<Int>()

        input.bufferedReader().forEachLine {
            if (it.isNotEmpty()) {
                food.add(it.toInt())
            } else {
                elves.add(Elf(food.toTypedArray()))
                food = mutableListOf()
            }
        }
    }

    fun part1(): Int = elves.maxBy { it.totalCalories() }.totalCalories()

    fun part2(): Int =
        elves.sortedByDescending { it.totalCalories() }
            .take(3)
            .fold(0) { acc, e -> acc + e.totalCalories() }
}
