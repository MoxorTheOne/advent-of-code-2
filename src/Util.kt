import java.io.File

fun readInput(name: String) = File("src", "Data/$name.txt")
    .readLines()

fun readRawInput(name: String) = File("src", "Data/$name.txt").readText()

fun rotateMatrix90Right(removeBottom: List<List<String>>): MutableList<MutableList<String>> {
    val width = removeBottom.maxOf { it.count() }
    val height = removeBottom.size
    val out = MutableList(width) { MutableList(height) { "" } }
    for (i in 0 until height) {
        for (j in 0 until width) {
            try {
                out[j][i] = removeBottom[i][j]
            } catch (e: Exception) {
                out[i][j] = ""
            }
        }
    }
    return out
}
