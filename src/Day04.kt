fun main() {
    val input = readInput("Day04")
        .map { it.split(",") }
        .map { pairToElves(it) }

    println("Part One ${input.count { it[0].fullOverlaps(it[1]) }}")
    println("Part Two ${input.count { it[0].overlaps(it[1]) }}")
}

fun pairToElves(pair: List<String>): List<Elve> = pair
    .map { it.split("-") }
    .map { Elve(it[0].toInt(), it[1].toInt()) }

data class Elve(val from: Int, val to: Int) {
    private var range: IntRange = IntRange(from, to)

    fun overlaps(other: Elve): Boolean =
        range.contains(other.from) ||
                range.contains(other.to) ||
                other.range.contains(from) ||
                other.range.contains(to)

    fun fullOverlaps(other: Elve): Boolean = this.contains(other) || other.contains(this)
    fun contains(other: Elve): Boolean = from <= other.from && to >= other.to
}