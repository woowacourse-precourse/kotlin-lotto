package lotto

import java.lang.NumberFormatException
import kotlin.IllegalArgumentException

class WinningNumber(_winning: String) {
    private val winnings = mutableListOf<Int>()

    init {
        validateNumeric(_winning)
        validateSize(winnings)
        validateRange(winnings)
        validateDuplicate(winnings)
    }

    private fun validateNumeric(numbers: String) {
        numbers.split(",").forEach { number ->
            try {
                winnings.add(number.toInt())
            } catch (exception: NumberFormatException) {
                throw IllegalArgumentException(ErrorMessage.intError(Constant.WINNING_NUMBER))
            }
        }
    }

    fun getWinningNumber() = winnings

    fun validateSize(winningNumber: List<Int>) = require(winningNumber.size == 6) {
        ErrorMessage.sizeError(Constant.WINNING_NUMBER)
    }

    fun validateRange(luckyNumber: List<Int>) {
        val count = luckyNumber.filter { number ->
            number in 1..45
        }.size
        require(count == 6) {ErrorMessage.rangeError(Constant.WINNING_NUMBER)}
    }

    fun validateDuplicate(luckyNumber: List<Int>) = require(luckyNumber.distinct().size == 6) {
        ErrorMessage.duplicateError(Constant.WINNING_NUMBER)
    }
}