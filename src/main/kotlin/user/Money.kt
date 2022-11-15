package user

import util.Constants
import util.Error

class Money(private val input: String?) {
    init {
        checkNumberFormat(input)
        checkMoney(input)
    }

    private fun checkNumberFormat(input: String?) {
        val chk = input?.toIntOrNull()
        require(chk != null){
            Error.NUMBER_FORMAT_ERROR.message
        }
    }

    private fun checkMoney(input: String?) {
        val inputToInt = input?.toInt()
        if (inputToInt != null) {
            require(inputToInt % Constants.UNIT_OF_MONEY.constant == Constants.ZERO.constant && inputToInt != Constants.ZERO.constant) {
                Error.MONEY_UNIT_ERROR.message
            }
        }
    }
}