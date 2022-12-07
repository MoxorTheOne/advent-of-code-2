import java.util.*

fun main() {
    val input = readRawInput("Day05")
        .split("\n\n")

    val boxesStacksPartOne = BoxesStacks(input[0])
    val boxedParTwo = boxesStacksPartOne.copy()
    println("input:")
    boxesStacksPartOne.print()
    println()
    val instructions = input[1].lines()
        .map { it.split(" ") }
        .map { Instruction(it) }


    instructions.forEach { boxesStacksPartOne.execute(it) }
    println()
    instructions.forEach { boxedParTwo.executePartTwo(it) }

    println("Part One ${boxesStacksPartOne.printResult()}")
    println("Part Two ${boxedParTwo.printResult()}")
}

data class Instruction(val line: List<String>) {
    val amount: Int = line[1].toInt()
    val from: Int = line[3].toInt() - 1
    val to: Int = line[5].toInt() - 1

    override fun toString() = "Move $amount from $from to $to"
}

data class BoxesStacks(val input: String) {

    val stacks: List<ArrayDeque<String>> = parseInput(input)

    fun execute(instruction: Instruction) {
        repeat(instruction.amount) {
            stacks[instruction.to].push(stacks[instruction.from].pop())
        }
    }

    fun executePartTwo(instruction: Instruction) {
        val cache = mutableListOf<String>()
        repeat(instruction.amount) {
            cache.add(stacks[instruction.from].pop())
        }
        cache.reversed().forEach { stacks[instruction.to].push(it) }
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

    fun printResult(): String {
        return stacks.fold("") { a, b -> a + b.peek() }
    }
}