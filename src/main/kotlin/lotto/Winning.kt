package lotto

import java.lang.NumberFormatException
import kotlin.IllegalArgumentException

class Winning(_winningNumber: String) {
    private val winningNumber = mutableListOf<Int>()

    init {
        validateSplitWinningNumber(_winningNumber)
        validateWinningNumberSize(winningNumber)
        validateWinningNumberRange(winningNumber)
        validateWinningNumberDuplicate(winningNumber)
    }

    private fun validateSplitWinningNumber(numbers: String) {
        numbers.split(",").forEach { number ->
            try {
                winningNumber.add(number.toInt())
            } catch (exception: NumberFormatException) {
                throw IllegalArgumentException(ErrorMessage.intError(Constant.WINNING_NUMBER))
            }
        }
    }

    fun validateWinningNumberSize(winningNumber: List<Int>) = require(winningNumber.size == 6) {
        throw IllegalArgumentException(ErrorMessage.sizeError(Constant.WINNING_NUMBER))
    }

    fun getWinningNumber() = winningNumber

    fun validateWinningNumberRange(luckyNumber: List<Int>) {
        val count = luckyNumber.filter { number ->
            number in 1..45
        }.size
        require(count == 6) {
            throw IllegalArgumentException(ErrorMessage.rangeError(Constant.WINNING_NUMBER))
        }
    }

    fun validateWinningNumberDuplicate(luckyNumber: List<Int>) = require(luckyNumber.distinct().size == 6) {
        throw IllegalArgumentException(ErrorMessage.duplicateError(Constant.WINNING_NUMBER))
    }

}