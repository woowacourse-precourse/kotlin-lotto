package lotto.domain

import lotto.*

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

    fun validateLottoNumberRange(number: Int) {
        if (number !in LOTTO_START_NUMBER..LOTTO_END_NUMBER) throwException(LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE)
    }

    private fun throwException(errorMessage: String) {
        throw IllegalArgumentException(errorMessage)
    }
}