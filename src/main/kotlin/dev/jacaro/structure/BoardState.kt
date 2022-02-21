package dev.jacaro.structure

data class BoardState(val array: Array<Int>) {
    val cells = Array(9) { index ->
        Cell(this, index, array[index])
    }

    val isSuccess: Boolean
    get() = array.contentEquals(successArray)



    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BoardState) return false

        if (!array.contentEquals(other.array)) return false

        return true
    }

    override fun hashCode(): Int {
        return array.contentHashCode()
    }

    companion object {
        val successArray = arrayOf(1, 2, 3, 8, 0, 4, 7, 6, 5)
    }
}