package dev.jacaro.school.eightpuzzlesearch.algorithms

import dev.jacaro.school.eightpuzzlesearch.structure.BoardState
import dev.jacaro.school.eightpuzzlesearch.structure.FoundState
import dev.jacaro.school.eightpuzzlesearch.structure.MoveSeries
import dev.jacaro.school.eightpuzzlesearch.structure.SolutionNotFound
import dev.jacaro.school.eightpuzzlesearch.tree.BoardRoot
import dev.jacaro.school.eightpuzzlesearch.tree.BoardTree

object BreadthFirstSearch : Algorithm("Breadth First Search") {
    override fun search(start: BoardState) : FoundState {

        val boardRoot = BoardRoot(start)

        if (boardRoot.boardState.isSuccess)
            return FoundState(boardRoot, boardRoot, MoveSeries(boardRoot), 1)

        val queue = ArrayDeque<BoardTree>()


        val visited = mutableSetOf(boardRoot.boardState)
        queue.addAll(boardRoot.children)

        var lastDepth = queue.first().currentDepth
        //print("Depth: $lastDepth ")
        //println(queue.joinToString(separator = " | ") { it.boardState.singleLinePrint() })
        while (queue.firstOrNull() != null) {
            if (queue.first().currentDepth > lastDepth) {
                lastDepth = queue.first().currentDepth
                println("Depth: $lastDepth Visited: ${visited.size} QueueSize: ${queue.size}")
                System.gc()
                //println(queue.joinToString(separator = " | ") { it.boardState.singleLinePrint() })
            }

            val beingVisited = queue.removeFirst()



            if (beingVisited.boardState.isSuccess)
                return FoundState(boardRoot, beingVisited, MoveSeries(beingVisited), visited.size)


            for (child in beingVisited.children) {
                if (child.boardState !in visited) {
                    queue.addLast(child)
                    visited.add(child.boardState)
                }
            }
        }

        throw SolutionNotFound()
    }
}