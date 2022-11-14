package lotto.domain

import lotto.constants.Constant.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.constants.Constant.Companion.MINIMUM_LOTTO_NUMBER
import lotto.constants.Exception.Companion.EXCEPTION_INVALID_CHARACTER
import lotto.constants.Exception.Companion.EXCEPTION_INVALID_RANGE_NUMBER
import lotto.views.InputView.inputBonusNumber
import lotto.views.OutputView
import lotto.views.OutputView.printInputBonusNumber
import java.lang.IllegalArgumentException

class BonusNumber {
    init {
        printInputBonusNumber()
    }

    fun createBonusNumber(): Int {
        val bonusNumber = inputBonusNumber()
        checkBonusNumber(bonusNumber)
        return bonusNumber.toInt()
    }

    fun checkBonusNumber(bonusNumber: String) {
        if (!bonusNumber.all { Character.isDigit(it) }) {
            OutputView.printExceptionMessage(EXCEPTION_INVALID_CHARACTER)
            throw IllegalArgumentException(EXCEPTION_INVALID_CHARACTER)
        }
        if (bonusNumber.toInt() !in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) {
            OutputView.printExceptionMessage(EXCEPTION_INVALID_RANGE_NUMBER)
            throw IllegalArgumentException(EXCEPTION_INVALID_RANGE_NUMBER)
        }
    }
}