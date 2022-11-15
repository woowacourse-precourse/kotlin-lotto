package lotto

import lotto.Model.Lotto
import lotto.View.OutputView
import lotto.constants.*

class ValidateInput {
    fun validateRange(number: Int): Boolean {
        if (number < 1 || number > 45) {
            OutputView().printErrorMessage(ERROR_RANGE)
            throw IllegalArgumentException()
        }
        return true
    }

    fun validateNumber(input: String): Boolean {
        if (!input.all { Character.isDigit(it) }) {
            OutputView().printErrorMessage(ERROR_NOT_NUMBER)
            throw IllegalArgumentException()
        }
        return true
    }

    fun validateDuplicationBonusNum(lottoNumber: Lotto, bonusNum: Int): Boolean {
        if (lottoNumber.getNumbers().contains(bonusNum)) {
            OutputView().printErrorMessage(ERROR_DUPLICATION)
            throw IllegalArgumentException()
        }
        return true
    }

    fun validateLottoLength() {
        OutputView().printErrorMessage(ERROR_LENGTH)
        throw IllegalArgumentException()
    }

    fun validateDuplication(winningNumbers: List<Int>) {
        if (winningNumbers.distinct().size != 6) {
            OutputView().printErrorMessage(ERROR_DUPLICATION)
            throw IllegalArgumentException()
        }
    }

    fun validateMoney(money: Int): Boolean {
        if ((money % 1000 != 0) || (money == 0)) {
            OutputView().printErrorMessage(ERROR_WRONG_MONEY)
            throw IllegalArgumentException()
        }
        return true
    }
}