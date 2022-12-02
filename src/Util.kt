import java.io.File

class Util {

}

fun readInput(name: String) = File("src", "$name.txt")
    .readLines()

fun readRawInput(name: String) = File("src", "$name.txt").readText()
