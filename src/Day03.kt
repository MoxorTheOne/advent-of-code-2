fun main() {
    val input = readInput("Day03")
    println("Part One ${partOne(input)}")
    println("Part Two ${PartTwo(input)}")
}

private fun PartTwo(input: List<String>) = input.map { it.toCharArray() }
        .chunked(3)
        .map { findBadgeForGroup(it) }
        .map { values.indexOf(it) + 1 }
        .sum()

fun findBadgeForGroup(lists: List<CharArray>): Char {
    val result = lists[0].find { char -> lists[1].contains(char) && lists[2].contains(char) }
    return result!! //Should fail if not found
}

private fun partOne(readInput: List<String>) = readInput
        .map { listOf(it.substring(0, (it.length / 2)), it.substring(it.length / 2, it.length)) }
        .map { findCommon(it) }
        .map { values.indexOf(it) + 1 }
        .sum()

fun findCommon(input: List<String>): Char {
    val lists = input.map { it.toCharArray() }
    val result = lists[0].find { char -> lists[1].contains(char) }
    return result!! //Should fail if not found
}

val values = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"