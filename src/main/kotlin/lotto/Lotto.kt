package lotto

import lotto.Message.Companion.DUPLICATED_NUMBERS
import lotto.Message.Companion.NOT_NUMBER
import lotto.Message.Companion.NOT_SIX_NUMBERS
import lotto.Units.Companion.LOTTO_FIRST_NUMBER
import lotto.Units.Companion.LOTTO_LAST_NUMBER
import lotto.Units.Companion.LOTTO_UNIT

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LOTTO_UNIT) { NOT_SIX_NUMBERS }
        require(numbers.distinct().size == LOTTO_UNIT) { DUPLICATED_NUMBERS }
        require(correctNumbers(numbers)) { NOT_NUMBER }
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
