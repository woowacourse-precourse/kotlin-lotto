package lotto.domain

import lotto.LOTTO_AMOUNT_NEGATIVE_EXCEPTION_MESSAGE
import lotto.LOTTO_AMOUNT_TYPE_EXCEPTION_MESSAGE
import lotto.LOTTO_AMOUNT_UNIT_EXCEPTION_MESSAGE

object LottoExceptionHandler {
    fun validateIntType(amount: String) {
        amount.toIntOrNull() ?: throwException(LOTTO_AMOUNT_TYPE_EXCEPTION_MESSAGE)
    }

    fun validatePositiveNumber(amount: Int) {
        if (amount <= 0) throwException(LOTTO_AMOUNT_NEGATIVE_EXCEPTION_MESSAGE)
    }

    fun validateAmountUnit(amount: Int) {
        if (amount % 1000 != 0) throwException(LOTTO_AMOUNT_UNIT_EXCEPTION_MESSAGE)
    }

    private fun throwException(errorMessage: String) {
        throw IllegalArgumentException(errorMessage)
    }
}