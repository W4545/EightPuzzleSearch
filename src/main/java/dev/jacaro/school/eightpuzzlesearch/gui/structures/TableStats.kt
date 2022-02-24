package dev.jacaro.school.eightpuzzlesearch.gui.structures

import dev.jacaro.school.eightpuzzlesearch.algorithms.Algorithm
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import kotlin.time.Duration
import kotlin.time.DurationUnit

class TableStats(algorithm: Algorithm, success: Boolean, depthFound: Int, time: Duration, moveCount: Int) {

    private val algorithm = SimpleObjectProperty(algorithm)

    private val success = SimpleStringProperty(success.toString())

    private val depthFound = SimpleIntegerProperty(depthFound)

    private val timeFound = SimpleStringProperty(time.toString(DurationUnit.MILLISECONDS, 2))

    private val moveCount = SimpleIntegerProperty(moveCount)


    fun getAlgorithm(): Algorithm {
        return algorithm.get()
    }

    fun getSuccess(): String {
        return success.get()
    }

    fun getDepthFound(): Int {
        return depthFound.get()
    }

    fun getTimeFound(): String {
        return timeFound.get()
    }

    fun getMoveCount(): Int {
        return moveCount.get()
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TableStats) return false

        if (algorithm != other.algorithm) return false
        if (success != other.success) return false
        if (depthFound != other.depthFound) return false
        if (timeFound != other.timeFound) return false
        if (moveCount != other.moveCount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = algorithm.hashCode()
        result = 31 * result + success.hashCode()
        result = 31 * result + depthFound.hashCode()
        result = 31 * result + timeFound.hashCode()
        result = 31 * result + moveCount.hashCode()
        return result
    }

}