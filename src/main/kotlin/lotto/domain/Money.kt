package lotto.domain

import lotto.domain.LottoExceptionHandler.validateAmountUnit
import lotto.domain.LottoExceptionHandler.validatePositiveNumber

class Money(private val money: Int) {

    init {
        validatePositiveNumber(money)
        validateAmountUnit(money)
    }

    fun convertLottoCount(): Int = money.div(1000)
}