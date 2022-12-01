import java.io.File

fun main() {

    println("TEST result: ")
    val testInput = File(createPath(1, Environment.TEST)).readLines()
    val testResult = task2(testInput)
    println(testResult)

    println("PROD result: ")
    val prodInput = File(createPath(1, Environment.PROD)).readLines()
    val prodResult = task2(prodInput)
    println(prodResult)
}