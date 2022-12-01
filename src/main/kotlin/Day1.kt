fun task1(input: List<String>): Int =
    input.joinToString().split(", ,")
        .maxOf { elfLoad -> elfLoad.split(", ").sumOf { it.trim().toInt() } }

fun task2(input: List<String>): Int =
    input.joinToString().split(", ,")
        .map { elfLoad -> elfLoad.split(", ").sumOf { it.trim().toInt() } }
        .sortedDescending()
        .take(3)
        .sum()
