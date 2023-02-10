package gg.vance.day5

class Day5(inputPath: String) {
    private val stream = this::class.java.getResourceAsStream(inputPath) ?: throw Exception("puzzle input is empty")

    fun part1(): String {
        val stacks = mutableMapOf<Int, ArrayDeque<Char>>()
        val stackInput = Regex("""\[[A-Z]]""")
        val moveInput = Regex("""^move (?<move>\d+) from (?<from>\d+) to (?<to>\d+)$""")

        stream.bufferedReader().forEachLine {
            when {
                stackInput.containsMatchIn(it) -> {
                    insertCrates(it, stacks)
                }

                moveInput.matches(it) -> {
                    val parsed = moveInput.find(it)!!.groups as MatchNamedGroupCollection
                    val from = stacks[parsed["from"]!!.value.toInt()]
                    val to = stacks[parsed["to"]!!.value.toInt()]

                    for (i in 1..(parsed["move"]!!.value.toInt())) {
                        to?.addFirst(from?.removeFirst()!!)
                    }
                }
            }
        }

        return stacks.toSortedMap().values.map { it.first() }.fold("") { acc, n -> acc + n }
    }

    fun part2(): String {
        val stacks = mutableMapOf<Int, ArrayDeque<Char>>()
        val stackInput = Regex("""\[[A-Z]]""")
        val moveInput = Regex("""^move (?<move>\d+) from (?<from>\d+) to (?<to>\d+)$""")

        stream.bufferedReader().forEachLine {
            when {
                stackInput.containsMatchIn(it) -> {
                    insertCrates(it, stacks)
                }

                moveInput.matches(it) -> {
                    val parsed = moveInput.find(it)!!.groups as MatchNamedGroupCollection
                    val from = stacks[parsed["from"]!!.value.toInt()]
                    val to = stacks[parsed["to"]!!.value.toInt()]

                    val crates = mutableListOf<Char>()
                    for (i in 1..(parsed["move"]!!.value.toInt())) {
                        crates.add(from?.removeFirst()!!)
                    }
                    to?.addAll(0, crates)
                }
            }
        }

        return stacks.toSortedMap().values.map { it.first() }.fold("") { acc, n -> acc + n }
    }

    private fun insertCrates(it: String, stacks: MutableMap<Int, ArrayDeque<Char>>) {
        for (i in 0..it.length step 4) {
            val stackId = if (i > 0) i / 4 + 1 else 1

            val crate = it[i + 1]
            if (!crate.isWhitespace()) {
                stacks.getOrPut(stackId) { ArrayDeque() }.add(crate)
            }
        }
    }
}
