package lotto.utils

import lotto.domain.LottoNumber

object LottoExceptionHandler {
    fun validateIntType(amount: String) {
        requireNotNull(amount.toIntOrNull()) { INTEGER_TYPE_EXCEPTION_MESSAGE }
    }

    fun validateNotNegative(amount: Int) {
        require(amount >= 0) { LOTTO_AMOUNT_NEGATIVE_OR_ZERO_EXCEPTION_MESSAGE }
    }

    fun validateAmountUnit(amount: Int) {
        require(amount % LOTTO_PRICE == 0 && amount > 0) { LOTTO_AMOUNT_UNIT_EXCEPTION_MESSAGE }
    }

    fun validateLottoNumberRange(number: Int) {
        if (number !in LOTTO_START_NUMBER..LOTTO_END_NUMBER) throwException(LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE)
    }

    fun validateLottoSize(lotto: List<LottoNumber>) {
        require(lotto.size == LOTTO_SIZE) { LOTTO_SIZE_EXCEPTION_MESSAGE }
    }

    fun validateLottoNumberDuplication(lotto: List<LottoNumber>) {
        val notDuplicatedLotto = lotto.distinctBy { lottoNumber ->
            lottoNumber.number
        }

        require(notDuplicatedLotto.size == LOTTO_SIZE) { LOTTO_NUMBER_DUPLICATION_EXCEPTION_MESSAGE }
    }

    fun validateBonusNumberDuplication(lotto: List<LottoNumber>, bonusNumber: LottoNumber) {
        if (lotto.contains(bonusNumber)) throwException(BONUS_NUMBER_DUPLICATION_EXCEPTION_MESSAGE)
    }

    private fun throwException(errorMessage: String) {
        println(errorMessage)
        throw IllegalArgumentException(errorMessage)
    }
}