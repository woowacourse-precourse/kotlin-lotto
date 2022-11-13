package lotto.domain

import lotto.utils.LottoExceptionHandler.validateAmountUnit
import lotto.utils.LottoExceptionHandler.validatePositiveNumber

class Money(private val money: Int) {

    init {
        validatePositiveNumber(money)
        validateAmountUnit(money)
    }

    fun calculateYieldRate(investment: Money): String =
        String.format("%,.1f", money.toDouble() / investment.money * 100) + "%"

    fun convertLottoCount(): Int = money.div(1000)
}