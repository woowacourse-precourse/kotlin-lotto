package lotto.domain

import lotto.utils.Constants.LOTTO_PRICE
import lotto.utils.Constants.ZERO
import lotto.utils.ErrorMessage.ERROR_REMAINING_MONEY

class Money(private val purchasingAmount: Long) {
    private val amount: Long

    init {
        val remainder = purchasingAmount % LOTTO_PRICE
        require(remainder == ZERO) { ERROR_REMAINING_MONEY }
        amount = purchasingAmount
    }

    fun getAmountOfMoney(): Long {
        return amount
    }
}
