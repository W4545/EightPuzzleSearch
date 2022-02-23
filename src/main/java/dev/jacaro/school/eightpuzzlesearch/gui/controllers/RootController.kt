package dev.jacaro.school.eightpuzzlesearch.gui.controllers

import javafx.beans.value.ChangeListener
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import java.net.URL
import java.util.*

class RootController: Initializable {

    @FXML
    private lateinit var label0: Label

    @FXML
    private lateinit var label1: Label

    @FXML
    private lateinit var label2: Label

    @FXML
    private lateinit var label3: Label

    @FXML
    private lateinit var label4: Label

    @FXML
    private lateinit var label5: Label

    @FXML
    private lateinit var label6: Label

    @FXML
    private lateinit var label7: Label

    @FXML
    private lateinit var label8: Label

    @FXML
    private lateinit var boardGridPane: GridPane

    @FXML
    private lateinit var labelWrapper: VBox



    override fun initialize(location: URL?, resources: ResourceBundle?) {
        for (rowConstraint in boardGridPane.rowConstraints) {
            rowConstraint.minHeightProperty().bind(labelWrapper.widthProperty())
            rowConstraint.maxHeightProperty().bind(labelWrapper.widthProperty())
        }
    }


}