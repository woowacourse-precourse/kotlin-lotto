package lotto.domain

import lotto.utils.ErrorMessage
import lotto.utils.Constants.ZERO

class Money(private val money: String) {

    init {
        require(money.all { it.isDigit() }) {
            ErrorMessage.INPUT_NOT_NUMBERS
        }
        require((money.toInt() % LOTTERY_PRICE) == ZERO) {
            ErrorMessage.INPUT_NOT_REMAINING_MONEY
        }
        require(money[0].digitToInt() != ZERO) {
            ErrorMessage.INPUT_EXIST_FIRST_WORD_ZERO
        }
    }


    companion object {
        const val LOTTERY_PRICE = 1_000
    }
}
