package dev.jacaro.structure

data class MoveSeries(val boardStates: Array<BoardState>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MoveSeries) return false

        if (!boardStates.contentEquals(other.boardStates)) return false

        return true
    }

    override fun hashCode(): Int {
        return boardStates.contentHashCode()
    }
}