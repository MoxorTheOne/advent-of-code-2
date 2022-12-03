fun main() {
    val input = readInput("Day03")
    println("Part One ${partOne(input)}")
    println("Part Two ${partTwo(input)}")
}

private fun partOne(readInput: List<String>) = readInput
        .map { it.chunked(it.length / 2) }
        .map { findCommon(it) }
        .sumOf { values.indexOf(it) + 1 }

private fun partTwo(input: List<String>) = input.map { it.toCharArray() }
        .chunked(3)
        .map { findBadgeForGroup(it) }
        .sumOf { values.indexOf(it) + 1 }

fun findBadgeForGroup(lists: List<CharArray>): Char =
        lists[0].find { char -> lists[1].contains(char) && lists[2].contains(char) }!! //Should fail if not found

fun findCommon(input: List<String>): Char =
        findCommonChar(input.map { it.toCharArray() })

fun findCommonChar(input: List<CharArray>): Char =
        input[0].find { char -> input[1].contains(char) }!! //Should fail if not found

const val values = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"