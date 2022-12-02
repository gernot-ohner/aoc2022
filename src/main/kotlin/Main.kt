import java.io.File

fun main() {

    println("TEST result: ")
    val testInput = File(createPath(2, Environment.TEST)).readLines()
    val testResult = Day2.task2(testInput)
    println(testResult)

    println("PROD result: ")
    val prodInput = File(createPath(2, Environment.PROD)).readLines()
    val prodResult = Day2.task2(prodInput)
    println(prodResult)
}