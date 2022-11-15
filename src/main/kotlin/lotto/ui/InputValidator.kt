package lotto.ui

import lotto.domain.BonusNumber
import lotto.domain.Lotto
import lotto.enum.Configuration
import lotto.enum.ErrorString

class InputValidator {
    private fun String.isNumberString() = this.all { it.isDigit() }

    fun validateWinningNumbers(input: List<String>) {
        if (input.any { !it.isNumberString() })
            throw IllegalArgumentException(ErrorString.NOT_DIGIT.string)
    }

    fun validatePurchaseAmount(input: String) {
        when {
            !input.isNumberString() ->
                throw IllegalArgumentException(ErrorString.NOT_DIGIT.string)
            input.toInt() % Configuration.LOTTO_PRICE.number != 0 ->
                throw IllegalArgumentException(ErrorString.PURCHASE_AMOUNT_UNIT.string)
            input.toInt() < Configuration.LOTTO_PRICE.number ->
                throw IllegalArgumentException(ErrorString.MIN_PURCHASE_AMOUNT.string)
        }
    }

    fun validateBonusNumber(input: String) {
        if(!input.isNumberString())
            throw IllegalArgumentException(ErrorString.NOT_DIGIT.string)
    }

    fun validateDrawnNumber(winningNumbers: List<Int>, bonusNumber: BonusNumber) {
        if(bonusNumber.isMatched(winningNumbers))
            throw IllegalArgumentException(ErrorString.DUPLICATED_DRAWN_NUMBERS.string)
    }
}