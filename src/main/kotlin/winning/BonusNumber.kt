package winning

import util.Constants
import util.Game
import util.Error

class BonusNumber {
    fun getBonusNumber(winningNumber: List<Int>): Int {
        println(Game.BONUS_NUMBER_INPUT.message)
        val input = readLine()

        checkBonusNumberException(input, winningNumber)

        return input?.toInt() ?: Constants.ZERO.constant
    }

    private fun checkBonusNumberException(input: String?, winningNumber: List<Int>) {
        checkNumberFormat(input)
        checkNumberRange(input)
        checkDuplication(input, winningNumber)
    }

    private fun checkNumberFormat(input: String?) {
        try {
            input?.toInt()
        } catch (e: NumberFormatException) {
            require(false) {
                Error.NUMBER_FORMAT_ERROR.message
            }
        }
    }

    private fun checkNumberRange(input: String?) {
        val inputToNumber = input?.toInt()

        require(inputToNumber in Constants.LOTTO_NUMBER_MIN.constant..Constants.LOTTO_NUMBER_MAX.constant) {
            Error.LOTTO_RANGE_ERROR.message
        }
    }

    private fun checkDuplication(input: String?, winningNumber: List<Int>) {
        require(!winningNumber.contains(input?.toInt())) {
            Error.BONUS_NUMBER_DUPLICATION_ERROR.message
        }
    }
}