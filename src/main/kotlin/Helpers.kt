enum class Environment {
    TEST,
    PROD
}

fun createPath(day: Int, env: Environment) = "/Users/gernotohner/dev/aoc2022/src/main/resources/day$day/$env.txt"