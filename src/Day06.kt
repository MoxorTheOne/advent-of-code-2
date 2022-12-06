fun main() {
    fun allCharsDifferent(string: String): Boolean =
        string.toCharArray().all { a -> string.count { b -> b == a } == 1 }

    fun day06(input: String, window: Int): Int =
        input.indexOf(input.windowed(window).find { t -> allCharsDifferent(t) }!!) + window


    check(day06("bvwbjplbgvbhsrlpgdmjqwftvncz", 4) == 5)
    check(day06("nppdvjthqldpwncqszvftbrmjlhg", 4) == 6)
    check(day06("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 4) == 10)
    check(day06("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 4) == 11)

    println("Part One " + day06(readRawInput("Day06"), 4))

    check(day06("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 14) == 19)
    check(day06("bvwbjplbgvbhsrlpgdmjqwftvncz", 14) == 23)
    check(day06("nppdvjthqldpwncqszvftbrmjlhg", 14) == 23)
    check(day06("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 14) == 29)
    check(day06("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14) == 26)

    println("Part Two " + day06(readRawInput("Day06"), 14))
}