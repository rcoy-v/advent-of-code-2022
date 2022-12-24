package gg.vance.day1

class Elf(val food: Array<Int>) {
    fun totalCalories(): Int {
        return food.sum()
    }
}