package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { println(ERROR_LOTTO_NOT_SIX) }
        require(!checkDuplication()) { println(ERROR_LOTTO_DUPLICATION) }
    }

    private fun checkDuplication(): Boolean {
        return numbers.distinct().size < LOTTO_SIZE
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }
}
