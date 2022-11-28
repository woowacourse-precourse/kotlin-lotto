package lotto.domain.model

import lotto.utils.Constants
import lotto.utils.Constants.ZERO

class Money(private val userInput: String) {

    private val amount: Long

    init {
        validatePurchaseNum(userInput)
        amount = userInput.toLong()
    }

    fun getMoney() = this.amount

    fun calEarningRate(totalPrice: Long): Double {
        return (totalPrice / amount.toDouble() * 100.0)
    }

    private fun validatePurchaseNum(userInput: String) {
        require(userInput.isNotBlank() && userInput.all { Character.isDigit(it) }) {
            Constants.MONEY_MUST_NUMBER_TEXT
        }
        require(userInput.toInt() % MONEY_UNIT == ZERO) {
            Constants.MONEY_UNIT_NOT_CORRECT_TEXT
        }
    }

    companion object {
        private const val MONEY_UNIT = 1_000

    }
}