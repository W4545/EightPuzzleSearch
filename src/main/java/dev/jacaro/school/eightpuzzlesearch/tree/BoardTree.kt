package dev.jacaro.school.eightpuzzlesearch.tree

import dev.jacaro.school.eightpuzzlesearch.structure.BoardState

fun genChildren(boardTree: BoardTree): Array<BoardTree> {

    val emptySpace = boardTree.boardState.emptyCell

    val neighbors = emptySpace.neighbors

    return Array(neighbors.size) {
        val state = boardTree.boardState.genSwap(emptySpace, neighbors[it])
        BoardTree(boardTree, state, boardTree.currentDepth + 1)
    }
}

open class BoardTree(val parent: BoardTree?, val boardState: BoardState, val currentDepth: Int) {

    val children: Array<BoardTree> by lazy {
        if (boardState.isSuccess)
            emptyArray()
        else
            genChildren(this)
    }

    override fun toString(): String {
        return "BoardTree(boardState=$boardState, currentDepth=$currentDepth, children=${children.size})"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BoardTree) return false

        if (parent != other.parent) return false
        if (boardState != other.boardState) return false
        if (currentDepth != other.currentDepth) return false

        return true
    }

    private val parentHashCode: Int? by lazy {
        parent?.hashCode()
    }

    override fun hashCode(): Int {
        var result = parentHashCode ?: 0
        result = 31 * result + boardState.hashCode()
        result = 31 * result + currentDepth
        return result
    }
}