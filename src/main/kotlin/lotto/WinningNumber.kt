package lotto

import java.lang.NumberFormatException

class WinningNumber(_winning: String) {
    private val winnings = mutableListOf<Int>()

    init {
        validateType(_winning)
        validateSize(winnings)
        validateRange(winnings)
        validateDuplicate(winnings)
    }

    private fun validateType(numbers: String) {
        numbers.split(Constant.SPLIT_WINNING_NUMBER).forEach { number ->
            try {
                winnings.add(number.toInt())
            } catch (exception: NumberFormatException) {
                ErrorMessage.intError(Constant.WINNING_NUMBER)
            }
        }
    }

    fun validateSize(winnings: List<Int>) = require(winnings.size == Constant.LOTTO_COUNT) {
        ErrorMessage.sizeError(Constant.WINNING_NUMBER)
    }

    fun validateRange(winnings: List<Int>) {
        val count = winnings.filter { number ->
            number in Constant.START_LOTTO_RANGE..Constant.END_LOTTO_RANGE
        }.size
        require(count == Constant.LOTTO_COUNT) { ErrorMessage.rangeError(Constant.WINNING_NUMBER) }
    }

    fun validateDuplicate(winnings: List<Int>) = require(winnings.distinct().size == Constant.LOTTO_COUNT) {
        ErrorMessage.duplicateError(Constant.WINNING_NUMBER)
    }

    fun getWinningNumber() = winnings
}