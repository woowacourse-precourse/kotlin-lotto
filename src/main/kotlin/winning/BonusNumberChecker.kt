package winning

import util.Constants
import util.Error

class BonusNumberChecker(private val input: String?, private val winningNumber: List<Int>) {
    init {
        checkNumberFormat()
        checkNumberRange()
        checkDuplication()
    }

    fun changeInputToInt(): Int {
        return input?.toInt() ?: Constants.ZERO.constant
    }

    private fun checkNumberFormat() {
        val chk = input?.toIntOrNull()
        require(chk != null){
            Error.NUMBER_FORMAT_ERROR.message
        }
    }

    private fun checkNumberRange() {
        val inputToNumber = input?.toInt()

        require(inputToNumber in Constants.LOTTO_NUMBER_MIN.constant..Constants.LOTTO_NUMBER_MAX.constant) {
            Error.LOTTO_RANGE_ERROR.message
        }
    }

    private fun checkDuplication() {
        require(!winningNumber.contains(input?.toInt())) {
            Error.BONUS_NUMBER_DUPLICATION_ERROR.message
        }
    }
}