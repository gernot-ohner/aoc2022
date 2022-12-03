import java.io.File

fun main() {

    val day = 3
    println("TEST result: ")
    val testInput = File(createPath(day, Environment.TEST)).readLines()
    val testResult = Day3.task2(testInput)
    println(testResult)

    println("PROD result: ")
    val prodInput = File(createPath(day, Environment.PROD)).readLines()
    val prodResult = Day3.task2(prodInput)
    println(prodResult)
}