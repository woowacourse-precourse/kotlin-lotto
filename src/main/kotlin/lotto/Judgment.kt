package lotto

import lotto.Constant.Companion.ERROR_1_45_RANGE
import lotto.Constant.Companion.ERROR_ALREADY_IN
import lotto.Constant.Companion.ERROR_INT_OR_NULL
import lotto.Constant.Companion.ERROR_NUMERIC
import lotto.Constant.Companion.ERROR_SIX_LENGTH
import lotto.Constant.Companion.ERROR_THOUSAND
import lotto.Constant.Companion.LOTTO_PRICE
import lotto.Constant.Companion.LOTTO_SIZE

class Judgment {

    fun checkPurchaseAmount(input: String): Int {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException("$ERROR_INT_OR_NULL")
        }
        if (input.toInt() % LOTTO_PRICE != 0) {
            throw IllegalArgumentException("$ERROR_THOUSAND")
        }
        return getPurchaseNumber(input)
    }

    fun getPurchaseNumber(input: String): Int {
        var money = input.toInt()
        return money / LOTTO_PRICE
    }

    fun checkWinningNumber(lottoNumber: MutableList<Int>): Boolean {
        var winningNumber = lottoNumber.distinct().filter { it in 1..45 }
        if (winningNumber.size != LOTTO_SIZE) {
            throw IllegalArgumentException("$ERROR_SIX_LENGTH")
        }
        return true
    }

    fun checkBonusNumber(bonusNumber: String, winningNumber: MutableList<Int>) {
        if (bonusNumber.toIntOrNull() == null) {
            throw IllegalArgumentException("$ERROR_NUMERIC")
        } else if (bonusNumber.toInt() !in 1..45) {
            throw IllegalArgumentException("$ERROR_1_45_RANGE")
        } else if (bonusNumber.toInt() in winningNumber){
            throw IllegalArgumentException("$ERROR_ALREADY_IN")
        }
    }
}