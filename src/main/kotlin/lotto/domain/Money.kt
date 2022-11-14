package lotto.domain

import lotto.utils.Constants.LOTTO_PRICE
import lotto.utils.Constants.ZERO
import lotto.utils.ErrorMessage.ERROR_EXIST_FIRST_WORD_ZERO
import lotto.utils.ErrorMessage.ERROR_NOT_NUMBERS
import lotto.utils.ErrorMessage.ERROR_REMAINING_MONEY

class Money(private val purchasingAmount: String) {
    private val amount: Long

    init {
        validateMoney(purchasingAmount)
        amount = purchasingAmount.toLong()
    }

    private fun validateMoney(purchasingAmount: String) {
        require(purchasingAmount.all { it.isDigit() }) { ERROR_NOT_NUMBERS }
        require((purchasingAmount.toInt() % LOTTO_PRICE) == ZERO) { ERROR_REMAINING_MONEY }
        require(purchasingAmount[0].digitToInt() != ZERO) { ERROR_EXIST_FIRST_WORD_ZERO }
    }

    fun getAmountOfMoney(): Long {
        return amount
    }
}
