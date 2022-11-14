package lotto

import lotto.Message.Companion.DUPLICATED_NUMBERS_MESSAGE
import lotto.Message.Companion.NOT_NUMBER_MESSAGE
import lotto.Message.Companion.NOT_SIX_NUMBERS_MESSAGE
import lotto.Units.Companion.LOTTO_FIRST_NUMBER
import lotto.Units.Companion.LOTTO_LAST_NUMBER
import lotto.Units.Companion.LOTTO_SIZE

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LOTTO_SIZE) { NOT_SIX_NUMBERS_MESSAGE }
        require(numbers.distinct().size == LOTTO_SIZE) { DUPLICATED_NUMBERS_MESSAGE }
        require(correctNumbers(numbers)) { NOT_NUMBER_MESSAGE }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    private fun correctNumbers(numbers: List<Int>): Boolean {
        for (number in numbers) {
            if (number !in LOTTO_FIRST_NUMBER..LOTTO_LAST_NUMBER) return false
        }
        return true
    }

}
