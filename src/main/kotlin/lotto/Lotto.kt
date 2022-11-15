package lotto

import lotto.Messages.Companion.DUPLICATE_NUMBER_ERROR
import lotto.Messages.Companion.NUMBER_COUNT_ERROR
import lotto.Messages.Companion.NUMBER_RANGE_ERROR

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { NUMBER_COUNT_ERROR }
        require(numbers.distinct().size == LOTTO_SIZE) { DUPLICATE_NUMBER_ERROR }
        numbers.forEach {
            require(it in MIN_NUMBER..MAX_NUMBER) { NUMBER_RANGE_ERROR }
        }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val LOTTO_SIZE = 6
        const val LOTTO_PRICE = 1000
    }
}
