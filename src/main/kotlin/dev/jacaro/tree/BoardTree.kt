package dev.jacaro.tree

import dev.jacaro.structure.BoardState

fun getMaxDepth(children: Array<BoardTree>?, currentDepth: Int) : Int {
    return if (children == null)
        currentDepth
    else
        children.maxOfOrNull { current -> getMaxDepth(current.children, currentDepth + 1) } ?: 0
}

sealed class BoardTree(val parent: BoardTree?, val boardState: BoardState, val currentDepth: Int) {

    var children: Array<BoardTree>? = null

    val maxDepth: Int
    get() = getMaxDepth(children, currentDepth)
}