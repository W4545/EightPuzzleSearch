package dev.jacaro.school.eightpuzzlesearch.algorithms

import dev.jacaro.school.eightpuzzlesearch.structure.BoardState
import dev.jacaro.school.eightpuzzlesearch.structure.FoundState
import dev.jacaro.school.eightpuzzlesearch.structure.MoveSeries
import dev.jacaro.school.eightpuzzlesearch.structure.SolutionNotFound
import dev.jacaro.school.eightpuzzlesearch.tree.BoardRoot
import dev.jacaro.school.eightpuzzlesearch.tree.BoardTree

object DepthFirstSearch : Algorithm("Depth First Search") {

    private data class StackState(val currentNode: BoardTree, val remainingChildren: Array<BoardTree>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is StackState) return false

            if (currentNode != other.currentNode) return false
            if (!remainingChildren.contentEquals(other.remainingChildren)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = currentNode.hashCode()
            result = 31 * result + remainingChildren.contentHashCode()
            return result
        }
    }

    override fun search(start: BoardState) : FoundState {
        val root = BoardRoot(start)

        if (root.boardState.isSuccess)
            return FoundState(root, root, MoveSeries(root), 1)

        val visitedNodes = mutableSetOf(root.boardState)

        val stack = ArrayDeque<StackState>()


        stack.addFirst(StackState(root, root.children.sliceArray(1 until root.children.size)))
        var currentNode = root.children.first()

        while (stack.isNotEmpty()) {
            if (currentNode.boardState in visitedNodes) {
                var trackBack = stack.removeFirst()
                while (trackBack.remainingChildren.isEmpty()) {
                    trackBack = stack.removeFirstOrNull() ?: throw SolutionNotFound()
                }
                stack.addFirst(StackState(currentNode, trackBack.remainingChildren.sliceArray(1 until trackBack.remainingChildren.size)))
                currentNode = trackBack.remainingChildren.first()
            } else {

                visitedNodes.add(currentNode.boardState)

                if (currentNode.boardState.isSuccess)
                    return FoundState(root, currentNode, MoveSeries(currentNode), visitedNodes.size)

                stack.addFirst(StackState(currentNode, currentNode.children.sliceArray(1 until currentNode.children.size)))

                currentNode = currentNode.children.first()
            }
        }


        throw SolutionNotFound()
    }

}