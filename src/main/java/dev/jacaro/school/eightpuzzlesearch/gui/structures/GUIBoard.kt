package dev.jacaro.school.eightpuzzlesearch.gui.structures

import dev.jacaro.school.eightpuzzlesearch.algorithms.Algorithm
import dev.jacaro.school.eightpuzzlesearch.structure.FoundState
import javafx.beans.property.SimpleStringProperty
import kotlin.time.Duration


class GUIBoard(array: Array<Triple<Algorithm, FoundState?, Duration?>>) {

    val bfs = array[0].second

    val dfs = array[1].second

    val ufs = array[2].second
}