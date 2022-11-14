package lotto.ui

import lotto.enum.Configuration
import lotto.enum.ErrorString

class InputValidator {
    private fun String.isNumberString() = this.all { it.isDigit() }

    fun validateWinningNumbers(input: List<String>){
        when{
            input.any{ !it.isNumberString() || it.toInt() !in 1..45 } ->
                throw IllegalArgumentException(ErrorString.OUT_OF_BOUND.string)
            input.size != 6 ->
                throw IllegalArgumentException(ErrorString.LOTTO_SIZE.string)
        }
    }

    fun validatePurchaseAmount(input: String) {
        when {
            !input.isNumberString() ->
                throw IllegalArgumentException(ErrorString.NOT_DIGIT.string)
            input.toInt() % 1000 != 0 ->
                throw IllegalArgumentException(ErrorString.PURCHASE_AMOUNT_UNIT.string)
        }
    }

    fun validateBonusNumber(input: String){
        when{
            !input.isNumberString() || input.toInt() !in 1..45 ->
                throw IllegalArgumentException(ErrorString.OUT_OF_BOUND.string)
        }
    }

    fun validateDrawnNumber(winningNumber: List<Int>, bonusNumber: Int){
        val uniqueNumbers = winningNumber.toMutableSet()
        uniqueNumbers.add(bonusNumber)
        if(uniqueNumbers.size != Configuration.LOTTO_SIZE.number + 1)
            throw IllegalArgumentException(ErrorString.DUPLICATED_DRAWN_NUMBERS.string)
    }
}