package com.kotlinlearn.kotlinlearn

fun main() {
    val puzzle = ZebraPuzzle()

    if (puzzle.res) {
        println("Drinks water: ${puzzle.drinksWater()}")
        println("Owns zebra: ${puzzle.ownsZebra()}")
    } else {
        println("No solution found")
    }
}