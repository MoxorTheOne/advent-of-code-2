import java.util.*

fun main() {
    val input = readRawInput("Day05")
        .split("\n\n")

    val boxesStacks = BoxesStacks(input[0])
    println("input:")
    boxesStacks.print()
    println()
    input[1].lines()
        .map { it.split(" ") }
        .map { Instruction(it) }
        .forEach { boxesStacks.execute(it) }
    println("result:")
    boxesStacks.print()
    println()
    boxesStacks.printPartOne()


//    println("Part One ${input.count { it[0].fullOverlaps(it[1]) }}")
//    println("Part Two ${input.count { it[0].overlaps(it[1]) }}")
}

data class Instruction(val line: List<String>) {
    val amount: Int = line[1].toInt()
    val from: Int = line[3].toInt() - 1
    val to: Int = line[5].toInt() - 1

    override fun toString() = "Move $amount from $from to $to"
}

class BoxesStacks(input: String) {

    val stacks: List<ArrayDeque<String>> = parseInput(input)

    fun execute(instruction: Instruction) {
        for (i in 0 until instruction.amount) {
            stacks[instruction.to].push(stacks[instruction.from].pop())
        }
    }

    fun print() = stacks.forEach { println(it) }

    private fun parseInput(input: String): List<ArrayDeque<String>> {
        val lines = input
            .lines()
            .map { it.chunked(4) }

        val removeBottom = lines.subList(0, lines.size - 1)

        return rotateMatrix90Right(removeBottom)
            .map { clean(it) }
            .map { it.reversed() }
            .map { ArrayDeque(it) }
    }

    private fun clean(it: MutableList<String>) = it.reversed()
        .map { it.trim() }
        .filter { it != "" }
        .map {
            it.replace("[", "").replace("]", "")
        }

    fun printPartOne() {
        stacks.forEach { print(it.peek()) }
    }
}