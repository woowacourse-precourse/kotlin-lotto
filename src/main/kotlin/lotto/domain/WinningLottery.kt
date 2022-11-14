package lotto.domain

import lotto.utils.Constants.LOTTO_NUMBER_COUNT
import lotto.utils.Constants.LOTTO_MAX_RANGE
import lotto.utils.Constants.LOTTO_MIN_RANGE
import lotto.utils.Constants.ZERO
import lotto.utils.ErrorMessage.ERROR_CONTAIN_HALF_SPOT
import lotto.utils.ErrorMessage.ERROR_NUMBER_SIZE_OVER
import lotto.utils.ErrorMessage.ERROR_NUMBER_DUPLICATE
import lotto.utils.ErrorMessage.ERROR_NOT_NUMBER_IN_RANGE
import lotto.utils.ErrorMessage.ERROR_NOT_NUMBERS

class WinningLottery(private val winningLottery: String, private val bonus: String) {
    private var numbers = mutableListOf<Int>()
    private var bonusNumber = ZERO

    init {
        val numbers = validateNumbers(winningLottery.split(','))
        numbers.forEach { this.numbers.add(it.toInt()) }
        this.numbers = this.numbers.sorted() as MutableList<Int>

        validateBonusNumber(bonus)
        bonusNumber = bonus.toInt()
    }

    fun getNumber(): List<Int> {
        return numbers
    }

    fun getBonusNumber(): Int {
        return bonusNumber
    }

    private fun validateBonusNumber(bonus: String) {
        require(bonus.all { it.isDigit() }) { ERROR_NOT_NUMBERS }
        require(bonus.toInt() in LOTTO_MIN_RANGE..LOTTO_MAX_RANGE) { ERROR_NOT_NUMBER_IN_RANGE }
        require(!winningLottery.contains(bonus)) { ERROR_NUMBER_DUPLICATE }
    }

    private fun validateNumbers(numbers: List<String>): List<String> {
        require(numbers.joinToString("").all { it.isDigit() }) { ERROR_NOT_NUMBERS }
        require(numbers[numbers.lastIndex].isNotEmpty()) { ERROR_CONTAIN_HALF_SPOT }
        require(numbers.size == LOTTO_NUMBER_COUNT) { ERROR_NUMBER_SIZE_OVER }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { ERROR_NUMBER_DUPLICATE }
        require(numbers.all { it.toInt() in LOTTO_MIN_RANGE..LOTTO_MAX_RANGE }) { ERROR_NOT_NUMBER_IN_RANGE }

        return numbers
    }
}
