package lotto.domain

import lotto.constants.Exception

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        checkDuplication(numbers)
    }

    private fun checkDuplication(numbers: List<Int>) {
        if (numbers.distinct().size != numbers.size) {
            throw IllegalArgumentException(Exception.EXCEPTION_DUPLICATED_NUMBER)
        }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
