suspend fun main() {
    val coso = readInput("Day01")
        .fold(Coso(mutableListOf(), 0)) { sum, element -> sum.take(element) }

    coso.printPartOne()
    coso.printPartTwo()

}

data class Coso(val totals: MutableList<Int>, val index: Int) {

    fun take(input: String): Coso {
        if (input.isNullOrBlank())
            return Coso(totals, index + 1)

        if (index == totals.size)
            totals.add(0)

        totals[index] = totals[index] + input.toInt()
        return this;
    }

    fun printPartOne() {
        println("Part one " + totals.maxOf { a -> a })
    }

    fun printPartTwo() {
        totals.sortDescending()
        println("Part two " +  totals.take(3).sum())
    }
}