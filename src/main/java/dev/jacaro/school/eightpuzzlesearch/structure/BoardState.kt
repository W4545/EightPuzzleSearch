package dev.jacaro.school.eightpuzzlesearch.structure

data class BoardState(val array: Array<Int>) {

    val isSuccess: Boolean
        get() = array.contentEquals(successArray)

    val emptyCell: Cell by lazy {
        genCell(array.indexOf(0))
    }

    fun genCell(index: Int) : Cell {
        return Cell(this, index, array[index])
    }

    fun genSwap(cell1: Cell, cell2: Cell): BoardState {
        assert(cell1.boardState === this && cell2.boardState === this)
        assert(cell1.value == 0 || cell2.value == 0)

        val genArray = array.clone()
        genArray[cell1.position] = cell2.value
        genArray[cell2.position] = cell1.value

        return BoardState(genArray)
    }

    fun genHelperString(): String {
        return """
            ${array[0]} ${array[1]} ${array[2]}
            ${array[3]} ${array[4]} ${array[5]}
            ${array[6]} ${array[7]} ${array[8]}
        """.trimIndent().replace("0", "X")
    }

    fun singleLinePrint(): String {
        return """{${array[0]} ${array[1]} ${array[2]}, ${array[3]} ${array[4]} ${array[5]}, ${array[6]} ${array[7]} ${array[8]}}"""
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BoardState) return false

        if (!array.contentEquals(other.array)) return false

        return true
    }

    override fun hashCode(): Int {
        return array.contentHashCode()
    }

    override fun toString(): String = genHelperString()

    companion object {
        val successArray = arrayOf(1, 2, 3, 8, 0, 4, 7, 6, 5)
    }
}