package dev.jacaro.school.eightpuzzlesearch.entry

import dev.jacaro.school.eightpuzzlesearch.algorithms.Algorithm
import dev.jacaro.school.eightpuzzlesearch.structure.BoardState
import dev.jacaro.school.eightpuzzlesearch.structure.FoundState
import dev.jacaro.school.eightpuzzlesearch.structure.SolutionNotFound
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class GUI : Application() {
    override fun start(primaryStage: Stage?) {
        if (primaryStage == null)
            return

        val fxml = FXMLLoader(javaClass.getResource("/dev/jacaro/school/eightpuzzlesearch/resources/fxml/root.fxml"))


        val scene = Scene(fxml.load())

        primaryStage.scene = scene

        primaryStage.show()


    }

    companion object {
        val results = mutableListOf<Pair<Algorithm, FoundState>>()

        val startState = BoardState(arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8).apply { shuffle() })


        @JvmStatic
        fun main(args: Array<String>) {



            for (algorithm in algorithms) {
                try {
                    results.add(Pair(algorithm, algorithm.search(startState)))
                } catch (ex: SolutionNotFound) {
                    println("Solution not found")
                }
            }


            launch(GUI::class.java, *args)
        }
    }
}