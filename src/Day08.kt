fun main() {
    val treesMap: List<List<Tree>> = readInput("Day08_test")
        .map { line -> line.toCharArray().map { Tree(it.toString().toInt()) } }


    val rotated: MutableList<MutableList<Tree?>> = MutableList(treesMap.size) { MutableList(treesMap[0].size) { null } }

    for (i in treesMap.indices) {
        for (j in 0 until treesMap[i].size) {
            rotated[j][i] = treesMap[i][j]
            makeBordersVisible(treesMap, i, j)
        }
        sweep(treesMap[i])//horizontal
    }

    for (i in rotated.indices) {
        sweep(rotated[i].toList() as List<Tree>)//vertical
    }


    for (i in treesMap.indices) {
        println()
        for (j in 0 until treesMap[i].size) {
            print(if (treesMap[i][j].visible) "V" else "H")
        }
        print("  ")
        for (j in 0 until treesMap[i].size) {
            print(treesMap[i][j].height)
        }
    }

    println()
    println("Visible trees ${treesMap.sumOf { row -> row.count { t -> t.visible } }}")

}

private fun sweep(trees: List<Tree>) {
    val left = 0
    val right = 1
    trees.windowed(2)
        .takeWhile { pair -> pair[left].visible }
        .forEach { pair -> pair[right].visible = pair[left].height < pair[right].height || pair[right].visible }
    trees.reversed()
        .windowed(2)
        .takeWhile { pair -> pair[left].visible }
        .forEach { pair -> pair[right].visible = pair[left].height < pair[right].height || pair[right].visible }
}

fun makeBordersVisible(treesMap: List<List<Tree>>, i: Int, j: Int) {
    if (i == 0 || j == 0 || i == treesMap.size - 1 || j == treesMap[0].size - 1) {
        treesMap[i][j].visible = true
    }
}

data class Tree(
    val height: Int,
    var visible: Boolean = false
)