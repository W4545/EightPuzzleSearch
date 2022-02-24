package dev.jacaro.school.eightpuzzlesearch.entry

import javafx.application.Application
import javafx.application.Platform
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

        primaryStage.isResizable = false

        primaryStage.show()
        primaryStage.isAlwaysOnTop = true

        Platform.runLater { primaryStage.isAlwaysOnTop = false }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {


            launch(GUI::class.java, *args)
        }
    }
}