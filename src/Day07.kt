import java.util.*

fun main() {
    val lines = ArrayDeque(readInput("Day07"))
    lines.pop()//Skip first
    var instruction: String
    var current = Directory("/", null)
    val allDirectories = mutableListOf<Directory>()

    while (lines.isNotEmpty()) {
        instruction = lines.pop()

        if (isNavigateInto(instruction)) {
            current = current.directoryByName(directoryName(instruction))
        } else if (isGoBack(instruction)) {
            current = current.parent!!
        } else if (!isCommand(instruction)) {
            if (isDirectory(instruction)) {
                val directory = Directory(directoryName(instruction), current)
                current.subDirectories.add(directory)
                allDirectories.add(directory)
            } else {
                current.files.add(File(instruction))
            }
        }
    }

    while (current.parent != null)// Point to root
        current = current.parent!!

    val directoriesSizes = allDirectories.map { it.size }

    println("Part one ${directoriesSizes.filter { it <= 100000 }.sum()}")

    val minimumSpaceToFree = 30000000 - (70000000 - current.size)

    println("Part Two ${directoriesSizes.filter { it >= minimumSpaceToFree }.minOf { it }}")

}

class File(line: String) {
    val name: String
    val size: Int

    init {
        val split = line.split(" ")
        size = split[0].toInt()
        name = split[1]
    }
}

class Directory(
    val name: String,
    val parent: Directory?,
    var subDirectories: MutableList<Directory> = mutableListOf(),
    var files: MutableList<File> = mutableListOf()
) {
    val size: Int by lazy {
        files.fold(0) { acc, file -> acc + file.size } + subDirectories.fold(0) { acc, folder -> acc + folder.size }
    }

    fun directoryByName(name: String): Directory {
        return subDirectories.first { d -> d.name == name }
    }

    fun print(spacing: String = "") {
        println("$spacing- $name (dir) size $size")
        files.forEach { println("${spacing}- ${it.name} (file, size=${it.size})") }
        subDirectories.forEach { it.print("$spacing   ") }
    }
}

fun directoryName(line: String): String = line.substring(line.lastIndexOf(" ")).trim()
fun isNavigateInto(line: String) = line.startsWith("\$ cd ") && line != "\$ cd .."
fun isDirectory(line: String) = line.startsWith("dir ")
fun isGoBack(line: String) = line == "\$ cd .."
fun isCommand(line: String) = line.startsWith("$")