object Day2 {

    fun task1(input: List<String>): Int =
        input.map { parseOneRoundForTask1(it) }
            .map { Pair(it.you, computeOneRound(it)) }
            .sumOf { it.first.value + it.second.value }

    fun task2(input: List<String>): Int =
        input.map { parseOneRoundForTask2(it) }
            .map { Pair(it.you, computeOneRound(it)) }
            .sumOf { it.first.value + it.second.value }


    private fun parseOneRoundForTask1(it: String): Round {
        val (opponent, player) = it.split(" ").map { parseOneInstructionForTask1(it) }
        return Round(opponent, player)
    }

    private fun parseOneRoundForTask2(it: String): Round {
        val (opponent, player) = it.split(" ")

        val opponentInstruction = parseOneInstructionForTask1(opponent)
        val playerInstruction = parseOneInstructionForTask2(player, opponentInstruction)

        return Round(opponentInstruction, playerInstruction)
    }

    private fun parseOneInstructionForTask1(instruction: String): RPS {
        return when (instruction) {
            "A", "X" -> RPS.ROCK
            "B", "Y" -> RPS.PAPER
            "C", "Z" -> RPS.SCISSORS
            else -> throw RuntimeException("Bad Instruction")
        }
    }

    private fun parseOneInstructionForTask2(instruction: String, opponent: RPS): RPS {
        return when (opponent) {
            RPS.ROCK -> when (instruction) {
                "X" -> RPS.SCISSORS
                "Y" -> opponent
                "Z" -> RPS.PAPER
                else -> throw RuntimeException("Bad Instruction")
            }

            RPS.PAPER -> when (instruction) {
                "X" -> RPS.ROCK
                "Y" -> opponent
                "Z" -> RPS.SCISSORS
                else -> throw RuntimeException("Bad Instruction")
            }

            RPS.SCISSORS -> when (instruction) {
                "X" -> RPS.PAPER
                "Y" -> opponent
                "Z" -> RPS.ROCK
                else -> throw RuntimeException("Bad Instruction")
            }
        }
    }

    private fun computeOneRound(round: Round): Result {
        return when (round.you) {
            RPS.ROCK -> when (round.opponent) {
                RPS.ROCK -> Result.TIE
                RPS.PAPER -> Result.LOSS
                RPS.SCISSORS -> Result.WIN
            }

            RPS.PAPER -> when (round.opponent) {
                RPS.ROCK -> Result.WIN
                RPS.PAPER -> Result.TIE
                RPS.SCISSORS -> Result.LOSS
            }

            RPS.SCISSORS -> when (round.opponent) {
                RPS.ROCK -> Result.LOSS
                RPS.PAPER -> Result.WIN
                RPS.SCISSORS -> Result.TIE
            }
        }
    }
}

enum class RPS(val value: Int) {
    ROCK(1), PAPER(2), SCISSORS(3)
}

enum class Result(val value: Int) {
    WIN(6),
    TIE(3),
    LOSS(0)
}

data class Round(val opponent: RPS, val you: RPS)
