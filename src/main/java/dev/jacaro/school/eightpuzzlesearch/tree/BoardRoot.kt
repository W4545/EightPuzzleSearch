package dev.jacaro.school.eightpuzzlesearch.tree

import dev.jacaro.school.eightpuzzlesearch.structure.BoardState

class BoardRoot(boardState: BoardState) : BoardTree(null, boardState, 0) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BoardRoot) return false
        if (!super.equals(other)) return false
        return true
    }

    override fun toString(): String {
        return super.toString()
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}