package lotto.domain

import lotto.utils.Constants.LOTTO_PRICE
import lotto.utils.ErrorMessage
import lotto.utils.Constants.ZERO

class Money(private val purchasingAmount: String) {
    private val amount: Long

    init {
        validateMoney(purchasingAmount)
        amount = purchasingAmount.toLong()
    }

    private fun validateMoney(purchasingAmount: String) {
        require(purchasingAmount.all { it.isDigit() }) {
            ErrorMessage.INPUT_NOT_NUMBERS
        }
        require((purchasingAmount.toInt() % LOTTO_PRICE) == ZERO) {
            ErrorMessage.INPUT_NOT_REMAINING_MONEY
        }
        require(purchasingAmount[0].digitToInt() != ZERO) {
            ErrorMessage.INPUT_EXIST_FIRST_WORD_ZERO
        }
    }

    fun getAmountOfMoney(): Long {
        return amount
    }
}
