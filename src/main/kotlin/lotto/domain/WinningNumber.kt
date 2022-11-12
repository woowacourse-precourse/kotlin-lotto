package lotto.domain

import lotto.util.Constant
import lotto.util.ErrorMessage
import java.lang.NumberFormatException

class WinningNumber(_winning: String) {
    private val winnings = mutableListOf<Int>()

    init {
        validateType(_winning)
        validateSize(winnings)
        validateRange(winnings)
        validateDuplication(winnings)
    }

    private fun validateType(winning: String) = winning.split(Constant.SPLIT_WINNING_NUMBER).forEach {
        try {
            winnings.add(it.toInt())
        } catch (exception: NumberFormatException) {
            ErrorMessage.intError(Constant.WINNING_NUMBER)
        }
    }

    fun validateSize(winnings: List<Int>) = require(winnings.size == Constant.LOTTO_COUNT) {
        ErrorMessage.sizeError(Constant.WINNING_NUMBER)
    }

    fun validateRange(winnings: List<Int>) {
        val count = winnings.filter {
            it in Constant.START_LOTTO_RANGE..Constant.END_LOTTO_RANGE
        }.size
        require(count == Constant.LOTTO_COUNT) { ErrorMessage.rangeError(Constant.WINNING_NUMBER) }
    }

    fun validateDuplication(winnings: List<Int>) = require(winnings.distinct().size == Constant.LOTTO_COUNT) {
        ErrorMessage.duplicateError(Constant.WINNING_NUMBER)
    }

    fun getWinningNumber() = winnings
}