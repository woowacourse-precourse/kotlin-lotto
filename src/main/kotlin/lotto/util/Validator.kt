package lotto.util

import lotto.util.Constants.ERROR_MESSAGE_BODY_NUMBER_SHOULD_BE_IN_RANGE
import lotto.util.Constants.ERROR_MESSAGE_HEADER
import lotto.util.Constants.LOTTO_MAX_NUMBER
import lotto.util.Constants.LOTTO_MIN_NUMBER
import lotto.util.Constants.WINNING_NUMBER_COUNT

object Validator {

    fun isNotContainsCharacter(value: String): Boolean {
        return value.all { Character.isDigit(it) }
    }

    fun isDividedByUnit(value: Int): Boolean {
        return value % Constants.LOTTO_UNIT_NUMBER == 0
    }

    fun isCorrectFormatInputWinningNumber(value: List<String>): Boolean {
        require(isAllNumberInRange(value)) {
            ERROR_MESSAGE_HEADER + ERROR_MESSAGE_BODY_NUMBER_SHOULD_BE_IN_RANGE
        }
        return value.size == WINNING_NUMBER_COUNT
    }

    fun isCorrectFormatInputBonusNumber(value: String): Boolean {
        require(isNumberInRange(value)) {
            ERROR_MESSAGE_HEADER + ERROR_MESSAGE_BODY_NUMBER_SHOULD_BE_IN_RANGE
        }
        return value.all { it.isDigit() }
    }

    private fun isAllNumberInRange(value: List<String>): Boolean {
        return value.map { it.toInt() }.all {
            it in LOTTO_MIN_NUMBER .. LOTTO_MAX_NUMBER
        }
    }

    private fun isNumberInRange(value: String): Boolean {
        return value.toInt() in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER
    }
}