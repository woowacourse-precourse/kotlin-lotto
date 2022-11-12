package lotto.domain

import lotto.util.Constant
import lotto.util.ErrorMessage
import java.lang.NumberFormatException

class BonusNumber(_winning: List<Int>, _bonus: String) {
    private var bonus = 0
    private val winning = _winning

    init {
        validateType(_bonus)
        validateRange(bonus)
        validateDuplication(winning, bonus)
    }

    fun validateType(winningNumber: String) {
        bonus = try {
            winningNumber.toInt()
        } catch (exception: NumberFormatException) {
            ErrorMessage.intError(Constant.BONUS_NUMBER)
            throw IllegalArgumentException()
        }
    }

    fun validateRange(bonusNumber: Int) = require(bonusNumber in Constant.START_LOTTO_RANGE..Constant.END_LOTTO_RANGE) {
        ErrorMessage.rangeError(Constant.BONUS_NUMBER)
    }

    fun validateDuplication(winningNumber: List<Int>, bonusNumber: Int) =
        require(!winningNumber.contains(bonusNumber)) {
            ErrorMessage.duplicateError(Constant.BONUS_NUMBER)
        }

    fun getBonusNumber() = bonus
}