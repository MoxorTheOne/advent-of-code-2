import java.io.File

class Util {

}

fun readInput(name: String) = File("src", "$name.txt")
    .readLines()
