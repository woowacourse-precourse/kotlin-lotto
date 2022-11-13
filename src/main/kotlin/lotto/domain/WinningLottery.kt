package lotto.domain

import lotto.utils.Constants.LOTTO_NUMBER_COUNT
import lotto.utils.Constants.LOTTO_NUMBER_MAX_IN_RANGE
import lotto.utils.Constants.LOTTO_NUMBER_MIN_IN_RANGE
import lotto.utils.ErrorMessage.INPUT_LOTTO_NUMBER_SIZE
import lotto.utils.ErrorMessage.INPUT_LOTTO_NUMBER_DUPLICATE
import lotto.utils.ErrorMessage.INPUT_LOTTO_NUMBER_IN_RANGE
import lotto.utils.ErrorMessage.INPUT_NOT_NUMBERS

class WinningLottery(private val winningLottery: String) {

    private var numbers = mutableListOf<Int>()

    init {
        val numbers = validateNumbers(winningLottery)

        numbers.forEach { this.numbers.add(it.toInt()) }
        this.numbers = this.numbers.sorted() as MutableList<Int>
    }

    private fun validateNumbers(winningLottery: String): List<String> {
        val numbers = winningLottery.split(',')

        require(numbers.joinToString("").all { it.isDigit() }) {
            INPUT_NOT_NUMBERS
        }
        require(numbers.size == LOTTO_NUMBER_COUNT) {
            INPUT_LOTTO_NUMBER_SIZE
        }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) {
            INPUT_LOTTO_NUMBER_DUPLICATE
        }
        require(
            numbers.all { number ->
                number.toInt() in LOTTO_NUMBER_MIN_IN_RANGE..LOTTO_NUMBER_MAX_IN_RANGE
            }
        ) {
            INPUT_LOTTO_NUMBER_IN_RANGE
        }

        return numbers
    }

    fun getNumber(): List<Int> {
        return numbers
    }
}
