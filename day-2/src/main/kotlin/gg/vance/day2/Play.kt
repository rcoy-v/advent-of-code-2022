package gg.vance.day2

enum class Play(val points: Int) {
    Rock(1),
    Paper(2),
    Scissors(3);

    fun beats(): Play = when (this) {
        Rock -> Scissors
        Paper -> Rock
        Scissors -> Paper
    }

    fun loses(): Play = when (this) {
        Rock -> Paper
        Paper -> Scissors
        Scissors -> Rock
    }
}
