package dev.jacaro.school.eightpuzzlesearch.entry

import javafx.application.Application
import javafx.stage.Stage

class GUI : Application() {
    override fun start(primaryStage: Stage?) {
        if (primaryStage == null)
            return

        primaryStage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(GUI::class.java, *args)
        }
    }
}