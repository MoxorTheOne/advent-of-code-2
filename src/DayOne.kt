suspend fun main() {
    val elves = readRawInput("Day01")
        .split("\n\n")
        .map { elf -> elf.lines().map { it.toInt() }.sum() }
        .toMutableList()
    elves.sortDescending()

    println("Part One ${elves.maxOf { a -> a }}")
    println("Part two ${elves.take(3).sum()}")
}