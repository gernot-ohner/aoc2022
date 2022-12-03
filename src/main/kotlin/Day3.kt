object Day3 {

    fun task1(input: List<String>): Int =
        input.map { line ->
            val (part1, part2) = line.chunked(line.length / 2)
            val itemsInFirstBag = part1.toSet()
            part2.toCharArray().first { itemsInFirstBag.contains(it) }
        }.sumOf { toPriority(it) }

    fun task2(input: List<String>): Int =
        input.chunked(3).map { group ->
            val itemsInFirstBag = group[0].toSet()
            val itemsInSecondBag = group[1].toSet()
            group[2].first { itemsInFirstBag.contains(it) && itemsInSecondBag.contains(it) }
        }.sumOf { toPriority(it) }

    private fun toPriority(char: Char): Int =
        if (char.isUpperCase()) {
            char.code - 'A'.code + 27
        } else {
            char.code - 'a'.code + 1
        }
}