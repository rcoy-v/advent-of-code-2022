package gg.vance.day3

class Day3(inputPath: String) {
    private val priorities = mutableMapOf<Char, Int>()
    private val stream = this::class.java.getResourceAsStream(inputPath) ?: throw Exception("puzzle input is empty")

    init {
        for (p in 1..26) {
            priorities[(96 + p).toChar()] = p
        }

        for (p in 27..52) {
            priorities[(38 + p).toChar()] = p
        }
    }

    fun part1(): Int {
        var sum = 0

        stream.bufferedReader().forEachLine {
            val half = it.length / 2
            val compartment1 = it.take(half).toList()
            val compartment2 = it.takeLast(half).toList()

            sum += compartment1.intersect(compartment2)
                .sumOf { i -> priorities[i] ?: throw Exception("unable to find priority of: $i") }
        }

        return sum
    }

    fun part2(): Int {
        var sum = 0

        var group = mutableListOf<String>()
        stream.bufferedReader().forEachLine {
            group.add(it)

            if (group.size == 3) {
                sum += group[0].toList().intersect(group[1].toList()).intersect(group[2].toList())
                    .sumOf { i -> priorities[i] ?: throw Exception("unable to find priority of: $i") }
                group = mutableListOf()
            }
        }

        return sum
    }
}
