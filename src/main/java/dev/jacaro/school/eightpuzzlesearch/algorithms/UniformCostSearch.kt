package dev.jacaro.school.eightpuzzlesearch.algorithms

import dev.jacaro.school.eightpuzzlesearch.structure.BoardState
import dev.jacaro.school.eightpuzzlesearch.structure.FoundState
import dev.jacaro.school.eightpuzzlesearch.structure.MoveSeries
import dev.jacaro.school.eightpuzzlesearch.structure.SolutionNotFound
import dev.jacaro.school.eightpuzzlesearch.tree.BoardRoot


object UniformCostSearch : Algorithm("Uniform Cost Search") {

    override fun search(start: BoardState): FoundState {

        val boardRoot = BoardRoot(start)

        if (boardRoot.boardState.isSuccess)
            return FoundState(boardRoot, boardRoot, MoveSeries(boardRoot), 1)

        val list = sortedSetOf(*boardRoot.children)

        val visited = hashSetOf<BoardState>()

        var currentNode = list.first()
        list.remove(currentNode)

        var visitedCount = 0
        while (!currentNode.boardState.isSuccess && list.size != 0) {
            visitedCount += 1
            for (child in currentNode.children) {
                if (child.boardState !in visited) {
                    visited.add(child.boardState)
                    list.add(child)
                }
            }

            currentNode = list.first()
            list.remove(currentNode)
        }

        if (currentNode.boardState.isSuccess) {
            return FoundState(boardRoot, currentNode, MoveSeries(currentNode), visitedCount)
        }

        throw SolutionNotFound()
    }
}