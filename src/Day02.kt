suspend fun main() {

    //A for Rock, B for Paper, and C for Scissors
    //X for Rock, Y for Paper, and Z for Scissors
    //shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
    //plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won)

    //Opp, Me
    //A Y(Draw) -   X
    //B X(Lose) -   X
    //C Z(Win)  -   X

    val input = readInput("Day02")
        .map { it.split(" ") }

    println("Part 1 ${partOne(input)}")
    println("Part 2 ${partOne(input.map { swapMyInput(it) })}")
}

private fun swapMyInput(input: List<String>): List<String> {
    when (input[1]) {
        "X" -> return listOf(input[0], lose(input[0]))
        "Y" -> return listOf(input[0], draw(input[0]))
    }
    return listOf(input[0], win(input[0])) //Z
}

fun win(to: String): String {
    when (to) {
        "A" -> return "Y" //Rock - Paper
        "B" -> return "Z" //Paper - Scissors
    }
    return "X"//Scissors - Rock
}

fun draw(to: String): String {
    when (to) {
        "A" -> return "X"//Rock - Rock
        "B" -> return "Y"//Paper - Paper
    }
    return "Z"//Scissors - Scissors
}

fun lose(to: String): String {
    when (to) {
        "A" -> return "Z"//Rock - Scissors
        "B" -> return "X"//Paper - Rock
    }
    return "Y"//Scissors - Paper
}

private fun partOne(input: List<List<String>>) = input
    .map { roundPoints(it[0], it[1]) }
    .sum()

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
