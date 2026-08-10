package com.kotlinlearn.kotlinlearn

class ZebraPuzzle() {

    /*
    There are five houses.
    The Englishman lives in the red house.
    The Spaniard owns the dog.
    The person in the green house drinks coffee.
    The Ukrainian drinks tea.
    The green house is immediately to the right of the ivory house.
    The snail owner likes to go dancing.
    The person in the yellow house is a painter.
    The person in the middle house drinks milk.
    The Norwegian lives in the first house.
    The person who enjoys reading lives in the house next to the person with the fox.
    The painter's house is next to the house with the horse.
    The person who plays football drinks orange juice.
    The Japanese person plays chess.
    The Norwegian lives next to the blue house.
     */

    enum class House { Red, Green, Ivory, Blue, Yellow }
    enum class Nationality { English, Spanish, Ukrainian, Japanese, Norwegian }
    enum class Pet { Dog, Fox, Horse, Zebra, Snail }
    enum class Drink { Coffee, Tea, Milk, OJ, Water }
    enum class Occupation { Painter, Dancing, Reading, Football, Chess }

    val house = arrayOfNulls<House>(5)
    val nationality = arrayOfNulls<Nationality>(5)
    val pet = arrayOfNulls<Pet>(5)
    val drink = arrayOfNulls<Drink>(5)
    val occupation = arrayOfNulls<Occupation>(5)

    // Checks only the clues whose category arrays are non-null so far (earlier categories in the
    // nesting below are already assigned; later ones are still all-null). Return false to prune.
    private fun constraintsHoldSoFar(): Boolean {
        for (i in 0..4) {
            val currentHouse = house[i]
            val currentNationality = nationality[i]
            val currentPet = pet[i]
            val currentDrink = drink[i]
            val currentOccupation = occupation[i]
            if (
                (currentHouse == House.Red && currentNationality != null && currentNationality != Nationality.English) ||
                (currentHouse == House.Green && currentDrink != null && currentDrink != Drink.Coffee) ||
                (currentNationality == Nationality.Spanish && currentPet != null && currentPet != Pet.Dog) ||
                (currentNationality == Nationality.Ukrainian && currentDrink != null && currentDrink != Drink.Tea) ||
                (i > 0 && currentHouse == House.Green && house[i - 1] != House.Ivory) ||
                (currentPet == Pet.Snail && currentOccupation != null && currentOccupation != Occupation.Dancing) ||
                (currentHouse == House.Yellow && currentOccupation != null && currentOccupation != Occupation.Painter) ||
                (i == 2 && currentDrink != null && currentDrink != Drink.Milk) ||
                (i == 0 && currentNationality != null && currentNationality != Nationality.Norwegian) ||
                (currentOccupation == Occupation.Reading && pet.getOrNull(i + 1) != Pet.Fox && pet.getOrNull(i - 1) != Pet.Fox) ||
                (currentOccupation == Occupation.Painter && pet.getOrNull(i + 1) != Pet.Horse && pet.getOrNull(i - 1) != Pet.Horse) ||
                (currentOccupation == Occupation.Football && currentDrink != null && currentDrink != Drink.OJ) ||
                (currentNationality == Nationality.Japanese && currentOccupation != null && currentOccupation != Occupation.Chess) ||
                (currentNationality == Nationality.Norwegian && house.getOrNull(i + 1) != House.Blue && house.getOrNull(i - 1) != House.Blue)
            ) return false
        }
        return true
    }

    private fun <T> permutations(list: List<T>): List<List<T>> {
        if (list.size <= 1) return listOf(list)
        return list.indices.flatMap { i ->
            val rest = list.toMutableList().also { it.removeAt(i) }
            permutations(rest).map { listOf(list[i]) + it }
        }
    }

    // Fills `target` with every permutation of `values`, trying `next` (the rest of the search) after each.
    // Backtracks by moving on to the next permutation when `next` returns false.
    private fun <T> assignPermutations(values: List<T>, target: Array<T?>, next: () -> Boolean): Boolean {
        for (perm in permutations(values)) {
            perm.forEachIndexed { i, v -> target[i] = v }
            if (constraintsHoldSoFar() && next()) return true
        }
        target.fill(null) // undo: without this, a failed subtree leaves stale values for shallower checks to misread
        return false
    }

    private fun solve(): Boolean =
        assignPermutations(House.entries, house) {
            assignPermutations(Nationality.entries, nationality) {
                assignPermutations(Pet.entries, pet) {
                    assignPermutations(Drink.entries, drink) {
                        assignPermutations(Occupation.entries, occupation) {
                            true
                        }
                    }
                }
            }
        }

    val res = solve()
    fun drinksWater(): String {
        if (res){
            for (i in 0..4){
                if (drink[i] == Drink.Water) return nationality[i]!!.name
            }
        }
        return ""
    }

    fun ownsZebra(): String {
        if (res){
            for (i in 0..4){
                if (pet[i] == Pet.Zebra) return nationality[i]!!.name
            }
        }
        return ""
    }

}