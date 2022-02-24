package dev.jacaro.school.eightpuzzlesearch.gui.controllers

import dev.jacaro.school.eightpuzzlesearch.algorithms.Algorithm
import dev.jacaro.school.eightpuzzlesearch.entry.algorithms
import dev.jacaro.school.eightpuzzlesearch.entry.printFoundState
import dev.jacaro.school.eightpuzzlesearch.gui.structures.TableStats
import dev.jacaro.school.eightpuzzlesearch.structure.BoardState
import dev.jacaro.school.eightpuzzlesearch.structure.FoundState
import dev.jacaro.school.eightpuzzlesearch.structure.SolutionNotFound
import javafx.fxml.FXML
import javafx.fxml.Initializable
import java.net.URL
import java.util.*
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

class RootController: Initializable {


    @FXML
    private lateinit var boardController: BoardPanelController

    @FXML
    private lateinit var tableController: BoardTableController


    @OptIn(ExperimentalTime::class)
    private fun runAlgorithms(board: BoardState) {
        println("Start State: ${board.singleLinePrint()}")

        val tempResults = mutableListOf<Triple<Algorithm, FoundState?, Duration>>()

        for (algorithm in algorithms) {
            println("Starting ${algorithm.name}")

            var foundState: FoundState? = null

            val duration = measureTime {
                try {
                    foundState = algorithm.search(board)
                } catch (_: SolutionNotFound) {

                }
            }

            if (foundState == null)
                println("Algorithm \"${algorithm.name}\" failed to find a solution")
            else
                printFoundState(algorithm.name, foundState!!, duration)
            println("\n-------------------------------------------------------------------\n")

            tempResults.add(Triple(algorithm, foundState, duration))
        }

        val stats = tempResults.map { triple ->
            if (triple.second != null)
                TableStats(triple.first, true, triple.second!!.winState.currentDepth, triple.third, triple.second!!.moveSeries.moveSequence.size)
            else
                TableStats(triple.first, false, -1, triple.third, -1)
        }

        tableController.setStats(stats.toTypedArray())
        boardController.setBoard(tempResults.toTypedArray())
    }

    @FXML
    private fun randomBoard() {
        val startArray = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)

        startArray.shuffle()

        runAlgorithms(BoardState(startArray))
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {

    }


}