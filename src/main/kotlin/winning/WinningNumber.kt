package winning

import util.Constants
import util.Game
import util.Error

class WinningNumber {
    fun getWinningNumber(): List<Int> {
        println(Game.WINNING_NUMBER_INPUT.message)
        val input = readLine()?.split(Game.SPLIT.message)

        checkWinningNumberException(input)

        return changeIntList(input)
    }

    private fun checkWinningNumberException(input: List<String>?) {
        checkSize(input)
        checkNumberFormat(input)
        checkNumberRange(input)
        checkDuplication(input)
    }

    private fun checkSize(input: List<String>?) {
        require(input?.size == Constants.NUMBER_OF_LOTTO.constant) {
            Error.NUMBER_OF_LOTTO_ERROR.message
        }
    }

    private fun checkNumberFormat(input: List<String>?) {
        input?.forEach { it ->
            val chk = it.toIntOrNull()
            require(chk != null) {
                Error.NUMBER_FORMAT_ERROR.message
            }
        }
    }

    private fun checkNumberRange(input: List<String>?) {
        val inputNumber = changeIntList(input)

        inputNumber.forEach { it ->
            require(it in Constants.LOTTO_NUMBER_MIN.constant..Constants.LOTTO_NUMBER_MAX.constant) {
                Error.LOTTO_RANGE_ERROR.message
            }
        }
    }

    private fun checkDuplication(input: List<String>?) {
        require(input?.distinct() == input) {
            Error.LOTTO_DUPLICATION_ERROR.message
        }
    }

    private fun changeIntList(input: List<String>?): List<Int> {
        val inputNumber = mutableListOf<Int>()

        input?.forEach { it ->
            inputNumber.add(it.toInt())
        }

        return inputNumber
    }
}