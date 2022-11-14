package lotto.domain

import lotto.utils.LottoExceptionHandler.validateNotNegative

class Money(private val money: Int) {

    init {
        validateNotNegative(money)
    }

    fun calculateYieldRate(investment: Money): String =
        String.format("%,.1f", money.toDouble() / investment.money * 100) + "%"

    fun convertLottoCount(): Int = money.div(1000)
}