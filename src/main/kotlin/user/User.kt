package user

import util.Constants
import util.Game
import util.Error

class User {
    fun getMoney(): Int {
        println(Game.USER_INPUT.message)
        val input = readLine()

        checkMoneyException(input)

        return input?.toInt() ?: Constants.ZERO.constant
    }

    private fun checkMoneyException(input: String?) {
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