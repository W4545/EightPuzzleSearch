package dev.jacaro.school.eightpuzzlesearch.entry

import dev.jacaro.school.eightpuzzlesearch.algorithms.BreadthFirstSearch
import dev.jacaro.school.eightpuzzlesearch.algorithms.DepthFirstSearch
import dev.jacaro.school.eightpuzzlesearch.algorithms.UniformCostSearch
import dev.jacaro.school.eightpuzzlesearch.structure.BoardState
import dev.jacaro.school.eightpuzzlesearch.structure.FoundState
import dev.jacaro.school.eightpuzzlesearch.structure.SolutionNotFound
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

fun printFoundState(algorithm: String, foundState: FoundState, duration: Duration) {
    println("$algorithm Results")
    println("Start state: ${foundState.root.boardState.singleLinePrint()}")
    println("Win State: ${foundState.winState.boardState.singleLinePrint()}")
    println("Depth Found: ${foundState.winState.currentDepth}")
    println("Nodes Visited: ${foundState.nodesVisited}")
    println("Move Sequence Length: ${foundState.moveSeries.moveSequence.size - 1}")
    println("Time taken: $duration")
}

val algorithms = arrayOf(BreadthFirstSearch, DepthFirstSearch, UniformCostSearch)

@OptIn(ExperimentalTime::class)
fun main() {
    println("Hello World!")

    val startArray = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)

    startArray.shuffle()

    //val start = BoardState(startArray) // arrayOf(2, 8, 3, 1, 6, 4, 7, 0, 5)

    val start = BoardState(arrayOf(5, 8, 0, 3, 4, 1, 7, 6, 2))

    println("Start State: ${start.singleLinePrint()}")

    for (algorithm in algorithms) {
        println("Starting ${algorithm.name}")

        var foundState: FoundState? = null

        val duration = try {
            measureTime {
                foundState = algorithm.search(start)
            }
        } catch (ex: SolutionNotFound) {
            null
        }

        if (foundState == null)
            println("Algorithm \"${algorithm.name}\" failed to find a solution")
        else
            printFoundState(algorithm.name, foundState!!, duration!!)
        println("\n-------------------------------------------------------------------\n")
    }

    println("Execution Complete")
    //println("Move Sequence (${foundState.moveSeries.moveSequence.size} moves): \n${foundState.moveSeries.moveSequence.joinToString(separator = "\n-----\n") { it.genHelperString() }}")

}