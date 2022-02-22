package dev.jacaro.school.eightpuzzlesearch.structure

import dev.jacaro.school.eightpuzzlesearch.tree.BoardRoot
import dev.jacaro.school.eightpuzzlesearch.tree.BoardTree

data class FoundState(val root: BoardRoot, val winState: BoardTree, val moveSeries: MoveSeries, val nodesVisited: Int)