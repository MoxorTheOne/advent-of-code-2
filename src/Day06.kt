val day06exampleA = "bvwbjplbgvbhsrlpgdmjqwftvncz"//5
val day06exampleB = "nppdvjthqldpwncqszvftbrmjlhg"//6
val day06exampleC = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"//10
val day06exampleD = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"//11

fun main() {
    check(day06PartOne(day06exampleA) == 5)
    check(day06PartOne(day06exampleB) == 6)
    check(day06PartOne(day06exampleC) == 10)
    check(day06PartOne(day06exampleD) == 11)

    println("Part One " + day06PartOne(readRawInput("Day06")))

}

fun day06PartOne(input: String): Int {
    val startMarker = input.windowed(4)
        .find { t -> allCharsDifferent(t) }

    return input.indexOf(startMarker!!) + 4
}

fun allCharsDifferent(string: String): Boolean =
    string.toCharArray().all { a -> string.count { b -> b == a } == 1 }