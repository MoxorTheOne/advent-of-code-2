suspend fun main() {
    val output = readInput("Day03")
            .map { listOf(it.substring(0, (it.length / 2)), it.substring(it.length / 2, it.length)) }
            .map { findCommon(it) }
            .map { values.indexOf(it) +1 }


    println("Part One ${output.sum()}")
}

fun findCommon(input: List<String>): Char {
    val lists = input.map { it.toCharArray() }
    val result = lists[0].find { char -> lists[1].contains(char) }
    return result!! //Should fail if not found
}

val values = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"