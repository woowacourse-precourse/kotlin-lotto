package lotto.utils

import lotto.utils.ErrorMessage.ERROR_NOT_NUMBERS
import java.lang.IllegalArgumentException

object Validator {

    fun checkBonusNumber(input: String): Int {
        val regex = Regex("^[1-9]$|^[1-3][0-9]$|^4[0-5]$")
        if (!input.matches(regex)) {
            throw IllegalArgumentException(ERROR_NOT_NUMBERS)
        }

        return input.toInt()
    }

    fun checkNumber(input: String): Long {
        val regex = Regex("[1-9][0-9]+")
        if (!input.matches(regex)) {
            throw IllegalArgumentException(ERROR_NOT_NUMBERS)
        }

        return input.toLong()
    }
}
