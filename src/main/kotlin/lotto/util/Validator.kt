package lotto.util

import lotto.model.LottoMaker.Companion.winningNumber
import lotto.util.Constant.Companion.ERROR_1_45_RANGE
import lotto.util.Constant.Companion.ERROR_ALREADY_IN
import lotto.util.Constant.Companion.ERROR_INT_OR_NULL
import lotto.util.Constant.Companion.ERROR_NUMERIC
import lotto.util.Constant.Companion.ERROR_SIX_LENGTH
import lotto.util.Constant.Companion.ERROR_THOUSAND
import lotto.util.Constant.Companion.LOTTO_PRICE
import lotto.util.Constant.Companion.LOTTO_SIZE

object Validator {

    fun checkPurchaseAmount(input: String): String {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException(ERROR_INT_OR_NULL)
        }
        if (input.toInt() % LOTTO_PRICE != 0) {
            throw IllegalArgumentException(ERROR_THOUSAND)
        }
        return input
    }

    fun getPurchaseNumber(input: String): Int {
        var money = input.toInt()
        return money / LOTTO_PRICE
    }

    fun checkWinningNumber(input: String): List<Int> {
        var lottoNumber = mutableListOf<Int>()
        input.split(",").forEach() { it ->
            it.toIntOrNull()?.let { lottoNumber.add(it) }
        }
        lottoNumber.sort()
        var winningNumber = lottoNumber.distinct().filter { it in 1..45 }
        if (winningNumber.size != LOTTO_SIZE) {
            throw IllegalArgumentException(ERROR_SIX_LENGTH)
        }
        return winningNumber.sorted()
    }

    fun checkBonusNumber(input: String): String {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException(ERROR_NUMERIC)
        } else if (input.toInt() !in 1..45) {
            throw IllegalArgumentException(ERROR_1_45_RANGE)
        } else if (input.toInt() in winningNumber){
            throw IllegalArgumentException(ERROR_ALREADY_IN)
        }
        return input
    }
}