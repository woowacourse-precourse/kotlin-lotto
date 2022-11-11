package lotto

import java.lang.NumberFormatException
import kotlin.IllegalArgumentException

class WinningNumber(_winning: String) {
    private val winnings = mutableListOf<Int>()

    init {
        validateType(_winning)
        validateSize(winnings)
        validateRange(winnings)
        validateDuplicate(winnings)
    }

    private fun validateType(numbers: String) {
        numbers.split(",").forEach { number ->
            try {
                winnings.add(number.toInt())
            } catch (exception: NumberFormatException) {
                ErrorMessage.intError(Constant.WINNING_NUMBER)
            }
        }
    }

    fun validateSize(winningNumber: List<Int>) = require(winningNumber.size == Constant.LOTTO_COUNT) {
        ErrorMessage.sizeError(Constant.WINNING_NUMBER)
    }

    fun validateRange(luckyNumber: List<Int>) {
        val count = luckyNumber.filter { number ->
            number in Constant.START_LOTTO_RANGE..Constant.END_LOTTO_RANGE
        }.size
        require(count == Constant.LOTTO_COUNT) { ErrorMessage.rangeError(Constant.WINNING_NUMBER) }
    }

    fun validateDuplicate(luckyNumber: List<Int>) = require(luckyNumber.distinct().size == Constant.LOTTO_COUNT) {
        ErrorMessage.duplicateError(Constant.WINNING_NUMBER)
    }

    fun getWinningNumber() = winnings
}