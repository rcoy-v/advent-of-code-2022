package gg.vance.day4

class Day4(inputPath: String) {
    private val stream = this::class.java.getResourceAsStream(inputPath) ?: throw Exception("puzzle input is empty")

    fun part1(): Int {
        var fullyContained = 0

        stream.bufferedReader().forEachLine {
            val assignments = it.split(",").map { it.split("-").map { it.toInt() } }

            if (assignments[0][0] <= assignments[1][0] && assignments[0][1] >= assignments[1][1]) {
                fullyContained++
            } else if (assignments[1][0] <= assignments[0][0] && assignments[1][1] >= assignments[0][1]) {
                fullyContained++
            }
        }

        return fullyContained
    }

    fun part2(): Int {
        var fullyContained = 0

        stream.bufferedReader().forEachLine {
            val assignments = it.split(",").map { it.split("-").map { it.toInt() } }

            if (assignments[0][0] in assignments[1][0]..assignments[1][1]) {
                fullyContained++
            } else if (assignments[0][1] in assignments[1][0]..assignments[1][1]) {
                fullyContained++
            } else if (assignments[1][0] in assignments[0][0]..assignments[0][1]) {
                fullyContained++
            } else if (assignments[1][1] in assignments[0][0]..assignments[0][1]) {
                fullyContained++
            }
        }

        return fullyContained
    }
}
