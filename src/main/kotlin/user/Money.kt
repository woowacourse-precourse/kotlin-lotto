package user

import util.Constants
import util.Error

class Money(private val input: String?) {
    init {
        checkNumberFormat()
        checkMoney()
    }

    fun changeInputToInt(): Int {
        return input?.toInt() ?: Constants.ZERO.constant
    }

    private fun checkNumberFormat() {
        val chk = input?.toIntOrNull()
        require(chk != null) {
            Error.NUMBER_FORMAT_ERROR.message
        }
    }

    private fun checkMoney() {
        val inputToInt = input?.toInt()
        if (inputToInt != null) {
            require(inputToInt % Constants.UNIT_OF_MONEY.constant == Constants.ZERO.constant && inputToInt != Constants.ZERO.constant) {
                Error.MONEY_UNIT_ERROR.message
            }
        }
    }
}