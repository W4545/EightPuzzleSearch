package dev.jacaro.school.eightpuzzlesearch.gui.controllers

import dev.jacaro.school.eightpuzzlesearch.algorithms.Algorithm
import dev.jacaro.school.eightpuzzlesearch.gui.structures.GUIBoard
import dev.jacaro.school.eightpuzzlesearch.structure.BoardState
import dev.jacaro.school.eightpuzzlesearch.structure.FoundState
import dev.jacaro.school.eightpuzzlesearch.structure.MoveSeries
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ToggleButton
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.GridPane
import org.controlsfx.control.SegmentedButton
import java.net.URL
import java.util.*
import kotlin.time.Duration


class BoardPanelController : Initializable {

    @FXML
    private lateinit var boardStateButton: SegmentedButton

    @FXML
    private lateinit var boardGridPane: GridPane

    @FXML
    private lateinit var boardBFSStateButton: ToggleButton

    @FXML
    private lateinit var boardDFSStateButton: ToggleButton

    @FXML
    private lateinit var boardUFSStateButton: ToggleButton


    @FXML
    private lateinit var label8: Label

    @FXML
    private lateinit var label5: Label

    @FXML
    private lateinit var label2: Label

    @FXML
    private lateinit var label7: Label

    @FXML
    private lateinit var label6: Label

    @FXML
    private lateinit var label4: Label

    @FXML
    private lateinit var label3: Label

    @FXML
    private lateinit var label1: Label

    @FXML
    private lateinit var label0: Label


    @FXML
    private lateinit var boardForwardButton: Button

    @FXML
    private lateinit var boardLabel: Label

    @FXML
    private lateinit var boardBackButton: Button

    @FXML
    private lateinit var leftImage: ImageView

    @FXML
    private lateinit var rightImage: ImageView

    private var guiBoard: GUIBoard? = null

    private val currentBoardProperty = SimpleObjectProperty<BoardState?>(null)

    private var currentMoveSeries: MoveSeries? = null
    private var currentPos = 0

    private lateinit var allLabels : Array<Label>

    fun setBoard(array: Array<Triple<Algorithm, FoundState?, Duration?>>) {

        guiBoard = GUIBoard(array)

        if (guiBoard?.bfs != null) {
            guiBoard?.bfs?.apply {

                currentBoardProperty.set(root.boardState)
                boardStateButton.isDisable = false
                boardForwardButton.isDisable = false
                boardLabel.text = "Start"
                boardLabel.isVisible = true
                boardBackButton.isDisable = false

                boardBFSStateButton.fire()
                boardBFSStateButton.isSelected = true
            }
        } else {
            boardStateButton.isDisable = true
            boardForwardButton.isDisable = true
            boardLabel.isVisible = false
            boardBackButton.isDisable = true
            currentBoardProperty.set(null)
        }
    }

    @FXML
    private fun onBFSSelect() {
        currentMoveSeries = guiBoard?.bfs?.moveSeries
        currentPos = 0

        boardLabel.text = "Start"

        currentBoardProperty.set(currentMoveSeries!!.moveSequence[0])
    }

    @FXML
    private fun onDFSSelect() {
        currentMoveSeries = guiBoard?.dfs?.moveSeries
        currentPos = 0

        boardLabel.text = "Start"

        currentBoardProperty.set(currentMoveSeries!!.moveSequence[0])
    }

    @FXML
    private fun onUFSSelect() {
        currentMoveSeries = guiBoard?.ufs?.moveSeries
        currentPos = 0

        boardLabel.text = "Start"

        currentBoardProperty.set(currentMoveSeries!!.moveSequence[0])
    }

    @FXML
    private fun onBack() {
        if (currentPos == 0)
            return

        currentPos -= 1

        boardLabel.text = if (currentPos == 0)
            "Start"
        else
            currentPos.toString()
        currentBoardProperty.set(currentMoveSeries!!.moveSequence[currentPos])
    }

    @FXML
    private fun onForward() {
        if (currentPos + 1 == currentMoveSeries!!.moveSequence.size)
            return

        currentPos += 1
        boardLabel.text = currentPos.toString()

        currentBoardProperty.set(currentMoveSeries!!.moveSequence[currentPos])
    }


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        leftImage.image = Image(javaClass.getResource("/dev/jacaro/school/eightpuzzlesearch/resources/images/arrow-left.png")?.toString() ?: "")

        rightImage.image = Image(javaClass.getResource("/dev/jacaro/school/eightpuzzlesearch/resources/images/arrow-right.png")?.toString() ?: "")


        allLabels = arrayOf(label0, label1, label2, label3, label4, label5, label6, label7, label8)

        allLabels.forEachIndexed { index, label ->
            currentBoardProperty.addListener { _, _, newValue ->
                if (newValue == null)
                    label.text = ""
                else
                    label.text = newValue.array[index].toString()
            }
        }
    }
}