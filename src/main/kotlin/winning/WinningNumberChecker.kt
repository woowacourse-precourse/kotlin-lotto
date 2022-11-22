package winning

import util.Constants
import util.Error

class WinningNumberChecker(private val input: List<String>?) {
    init {
        checkSize()
        checkNumberFormat()
        checkNumberRange()
        checkDuplication()
    }

    fun changeIntToList(): List<Int> {
        val inputNumber = mutableListOf<Int>()

        input?.forEach { it ->
            inputNumber.add(it.toInt())
        }

        return inputNumber
    }

    private fun checkSize() {
        require(input?.size == Constants.NUMBER_OF_LOTTO.constant) {
            Error.NUMBER_OF_LOTTO_ERROR.message
        }
    }

    private fun checkNumberFormat() {
        input?.forEach { it ->
            val chk = it.toIntOrNull()
            require(chk != null) {
                Error.NUMBER_FORMAT_ERROR.message
            }
        }
    }

    private fun checkNumberRange() {
        val inputNumber = changeIntToList()

        inputNumber.forEach { n ->
            require(n in Constants.LOTTO_NUMBER_MIN.constant..Constants.LOTTO_NUMBER_MAX.constant) {
                Error.LOTTO_RANGE_ERROR.message
            }
        }
    }

    private fun checkDuplication() {
        require(input?.distinct() == input) {
            Error.LOTTO_DUPLICATION_ERROR.message
        }
    }
}