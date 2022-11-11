package lotto

import java.lang.NumberFormatException

class BonusNumber(_winningNumber: List<Int>, _bonusNumber: String) {
    private var bonusNumber = 0
    private val winningNumber = _winningNumber

    init {
        inputBonusNumber(_bonusNumber)
        validateBonusNumberDuplicate(bonusNumber)
        validateBonusNumberRange(bonusNumber)
    }

    fun getBonusNumber() = bonusNumber

    fun validateBonusNumberRange(bonusNumber: Int) = require(bonusNumber in 1..45) {
        throw IllegalArgumentException(ErrorMessage.rangeError(Constant.BONUS_NUMBER))
    }

    fun validateBonusNumberDuplicate(bonusNumber: Int) = require(winningNumber.contains(bonusNumber)) {
        throw IllegalArgumentException(ErrorMessage.duplicateError(Constant.BONUS_NUMBER))
    }

    fun inputBonusNumber(number: String) {
        bonusNumber = try {
            number.toInt()
        } catch (exception: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.intError(Constant.BONUS_NUMBER))
        }
    }
}