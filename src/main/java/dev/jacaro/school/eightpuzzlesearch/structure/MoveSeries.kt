package dev.jacaro.school.eightpuzzlesearch.structure

import dev.jacaro.school.eightpuzzlesearch.tree.BoardTree

class MoveSeries(winState: BoardTree) {

    val moveSequence: Array<BoardState> by lazy {
        val list = mutableListOf(winState.boardState)

        var parent = winState.parent
        while (parent != null) {
            list.add(parent.boardState)
            parent = parent.parent
        }

        list.reverse()
        list.toTypedArray()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MoveSeries) return false

        if (!moveSequence.contentEquals(other.moveSequence)) return false

        return true
    }

    override fun hashCode(): Int {
        return moveSequence.contentHashCode()
    }

    override fun toString(): String {
        return "MoveSeries()"
    }
}