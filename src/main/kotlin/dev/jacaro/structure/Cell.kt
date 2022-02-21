package dev.jacaro.structure



data class Cell(val boardState: BoardState, val position: Int, val value: Int) {

    val isEmptySpace = value == 0

    val neighbors: Array<Cell>
    get() = when(position) {
        0 -> neighborArrayGen(1, 3)
        1 -> neighborArrayGen(0, 2, 4)
        2 -> neighborArrayGen(1, 5)
        3 -> neighborArrayGen(0, 4, 6)
        4 -> neighborArrayGen(1, 3, 5, 7)
        5 -> neighborArrayGen(2, 4, 8)
        6 -> neighborArrayGen(3, 7)
        7 -> neighborArrayGen(4, 6, 8)
        8 -> neighborArrayGen(5, 7)
        else -> throw RuntimeException("Unreachable")
    }

    private fun neighborArrayGen(vararg positions: Int): Array<Cell> = positions.map { position ->
        boardState.cells[position]
    }.toTypedArray()
}