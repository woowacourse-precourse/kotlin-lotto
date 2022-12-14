package lotto.util

import lotto.util.Constant.ERROR_DISTINCT
import lotto.util.Constant.ERROR_IN_WINNING
import lotto.util.Constant.ERROR_NUMBER_FORMAT
import lotto.util.Constant.ERROR_RANGE
import lotto.util.Constant.ERROR_THOUSAND
import java.lang.IllegalArgumentException

object Validator {
    fun checkMoney(money: String) {
        if (money.toIntOrNull() == null) {
            throw IllegalArgumentException(ERROR_NUMBER_FORMAT)
        }
        if (money.toInt() % 1000 != 0) {
            throw IllegalArgumentException(ERROR_THOUSAND)
        }
    }

    fun checkWinningNumber(number: String): List<Int> {
        val winningNumber = mutableListOf<Int>()
        number.split(',').forEach {
            it.toIntOrNull()?.let { winningNumber.add(it) }
        }
        if (winningNumber.distinct().size != 6) {
            throw IllegalArgumentException(ERROR_DISTINCT)
        }
        for (number in winningNumber) {
            if (number !in 1..45) {
                throw IllegalArgumentException(ERROR_RANGE)
            }
        }
        return winningNumber.sorted().toList()
    }

    fun checkBonusNumber(number: String) {
        if (number.toIntOrNull() == null) {
            throw IllegalArgumentException(ERROR_NUMBER_FORMAT)
        }
        if (number.toInt() !in 1..45) {
            throw IllegalArgumentException(ERROR_RANGE)
        }
    }

    fun checkBonusInNumber(bonus: Int, winningNumber: List<Int>) {
        if (bonus in winningNumber) {
            throw IllegalArgumentException(ERROR_IN_WINNING)
        }
    }
}