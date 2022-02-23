package dev.jacaro.school.eightpuzzlesearch.gui.controllers

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ToggleButton
import javafx.scene.layout.GridPane
import org.controlsfx.control.SegmentedButton

class BoardPanel {

    @FXML
    private lateinit var boardStateButton: SegmentedButton

    @FXML
    private lateinit var boardGridPane: GridPane


    @FXML
    private lateinit var boardStartButton: ToggleButton

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
}