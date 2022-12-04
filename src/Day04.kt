fun main() {
    val input = readInput("Day04")
        .map { it.split(",") }
        .map { pairToElves(it) }
        .filter { it[0].overlaps(it[1]) }

    println("Part One ${input.count()}")
//    println("Part Two ${partTwo(input)}")
}

fun pairToElves(pair: List<String>): List<Elve> = pair
    .map { it.split("-") }
    .map { Elve(it[0].toInt(), it[1].toInt()) }

data class Elve(val from: Int, val to: Int) {
    fun overlaps(other: Elve): Boolean = this.contains(other) || other.contains(this)
    fun contains(other: Elve): Boolean = from <= other.from && to >= other.to
}