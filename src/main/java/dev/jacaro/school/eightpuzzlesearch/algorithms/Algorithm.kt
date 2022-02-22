package dev.jacaro.school.eightpuzzlesearch.algorithms

import dev.jacaro.school.eightpuzzlesearch.structure.BoardState
import dev.jacaro.school.eightpuzzlesearch.structure.FoundState
import dev.jacaro.school.eightpuzzlesearch.structure.SolutionNotFound

abstract class Algorithm(val name: String) {

    abstract fun search(start: BoardState) : FoundState

}