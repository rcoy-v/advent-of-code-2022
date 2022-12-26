package gg.vance.day2

class Day2(private val inputPath: String) {
    fun part1(): Int {
        val stream = this::class.java.getResourceAsStream(inputPath) ?: throw Exception("puzzle input is empty")
        var score = 0

        stream.bufferedReader().forEachLine {
            val round = it.split(" ").zipWithNext().single()
            val first = when (round.first) {
                "A" -> Play.Rock
                "B" -> Play.Paper
                "C" -> Play.Scissors
                else -> throw Exception("failed to parse first code")
            }
            val second = when (round.second) {
                "X" -> Play.Rock
                "Y" -> Play.Paper
                "Z" -> Play.Scissors
                else -> throw Exception("failed to parse second code")
            }

            score += when {
                first == second -> Outcome.Draw.points + second.points
                first.beats() == second -> Outcome.Loss.points + second.points
                second.beats() == first -> Outcome.Win.points + second.points
                else -> {
                    throw Exception("unknown round comparison")
                }
            }
        }

        return score
    }

    fun part2(): Int {
        val stream = this::class.java.getResourceAsStream(inputPath) ?: throw Exception("puzzle input is empty")
        var score = 0

        stream.bufferedReader().forEachLine {
            val round = it.split(" ").zipWithNext().single()
            val first = when (round.first) {
                "A" -> Play.Rock
                "B" -> Play.Paper
                "C" -> Play.Scissors
                else -> throw Exception("failed to parse first code")
            }
            val second = when (round.second) {
                "X" -> Outcome.Loss
                "Y" -> Outcome.Draw
                "Z" -> Outcome.Win
                else -> throw Exception("failed to parse second code")
            }

            score += when(second) {
                Outcome.Loss -> Outcome.Loss.points + first.beats().points
                Outcome.Draw -> Outcome.Draw.points + first.points
                Outcome.Win -> Outcome.Win.points + first.loses().points
            }
        }

        return score
    }
}