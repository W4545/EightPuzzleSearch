package dev.jacaro.school.eightpuzzlesearch.gui.controllers

import dev.jacaro.school.eightpuzzlesearch.algorithms.Algorithm
import dev.jacaro.school.eightpuzzlesearch.gui.structures.TableStats
import dev.jacaro.school.eightpuzzlesearch.structure.FoundState
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView

class BoardTableController {

    @FXML
    private lateinit var table: TableView<TableStats>

    @FXML
    private lateinit var algorithmColumn: TableColumn<TableStats, Algorithm>

    @FXML
    private lateinit var successColumn: TableColumn<TableStats, String>

    @FXML
    private lateinit var depthColumn: TableColumn<TableStats, Int>

    @FXML
    private lateinit var timeColumn: TableColumn<TableStats, String>

    @FXML
    private lateinit var movesColumn: TableColumn<TableStats, Int>

    private var foundState: FoundState? = null


    fun setStats(array: Array<TableStats>) {
        table.items = FXCollections.observableArrayList(*array)
    }
}