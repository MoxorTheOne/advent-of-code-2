suspend fun main() {

    //A for Rock, B for Paper, and C for Scissors
    //X for Rock, Y for Paper, and Z for Scissors
    //shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
    //plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won)

    val result = readInput("Day02")
        .map { it.split(" ") }
        .map { roundPoints(it[0], it[1]) }
        .sum()

    println("Part1 $result")

}

fun roundPoints(opponent: String, me: String): Int = shapeValue(me) + victoryPoints(opponent, me)

private fun victoryPoints(opponent: String, me: String): Int {
    if ((opponent == "A" && me == "X") || (opponent == "B" && me == "Y") || (opponent == "C" && me == "Z"))
        return 3 //Draw

    if ((opponent == "A" && me == "Y") || (opponent == "B" && me == "Z") || (opponent == "C" && me == "X"))
        return 6//Win

    return 0//Lose
}

private fun shapeValue(me: String): Int {
    when (me) {
        "X" -> return 1
        "Y" -> return 2
    }
    return 3
}
