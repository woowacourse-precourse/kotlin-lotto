package lotto

import lotto.Message.Companion.DUPLICATED_NUMBERS
import lotto.Message.Companion.NOT_NUMBER
import lotto.Message.Companion.NOT_SIX_NUMBERS

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { NOT_SIX_NUMBERS }
        require(numbers.distinct().size == 6) { DUPLICATED_NUMBERS }
        require(correctNumbers(numbers)) { NOT_NUMBER }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    private fun correctNumbers(numbers: List<Int>): Boolean {
        for (number in numbers) {
            if (number !in 1..45) return false
        }
        return true
    }

}
