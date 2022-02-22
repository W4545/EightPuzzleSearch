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

        val list = mutableListOf(boardRoot.children)

        throw SolutionNotFound()
    }
}