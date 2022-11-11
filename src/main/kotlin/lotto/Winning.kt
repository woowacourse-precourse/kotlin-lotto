package lotto

import java.lang.NumberFormatException
import kotlin.IllegalArgumentException

class Winning(winningNumber: String) {
    private val luckyNumber = mutableListOf<Int>()
    private var bonusNumber = 0

    init {
        validateSplitWinningNumber(winningNumber)
        require(luckyNumber.size == 6) { ErrorMessage.sizeError(Constant.WINNING_NUMBER) }
        validateWinningNumberRange(luckyNumber)
        validateWinningNumberDuplicate(luckyNumber)
    }

    private fun validateSplitWinningNumber(numbers: String) {
        numbers.split(",").forEach { number ->
            try {
                luckyNumber.add(number.toInt())
            } catch (exception: NumberFormatException) {
                throw IllegalArgumentException(ErrorMessage.intError(Constant.WINNING_NUMBER))
            }
        }
    }

    fun getWinningNumber() = luckyNumber

    fun getBonusNumber() = bonusNumber

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


    fun validateBonusNumberRange(bonusNumber: Int) = require(bonusNumber in 1..45) {
        throw IllegalArgumentException(ErrorMessage.rangeError(Constant.BONUS_NUMBER))
    }


    fun validateBonusNumberDuplicate(bonusNumber: Int) = require(luckyNumber.contains(bonusNumber)) {
        throw IllegalArgumentException(ErrorMessage.duplicateError(Constant.BONUS_NUMBER))
    }

    fun inputBonusNumber(number: String) {
        bonusNumber = try {
            number.toInt()
        } catch (exception: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.intError(Constant.BONUS_NUMBER))
        }
        checkBonusNumberException()
    }

    private fun checkBonusNumberException() {
        validateBonusNumberRange(bonusNumber)
        validateBonusNumberDuplicate(bonusNumber)
    }
}