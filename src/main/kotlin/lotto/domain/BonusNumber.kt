package lotto.domain

import lotto.constants.Constant.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.constants.Constant.Companion.MINIMUM_LOTTO_NUMBER
import lotto.constants.Exception.Companion.EXCEPTION_INVALID_CHARACTER
import lotto.views.InputView.inputBonusNumber
import lotto.views.OutputView.printInputBonusNumber
import java.lang.IllegalArgumentException

class BonusNumber {
    init {
        printInputBonusNumber()
    }

    fun createBonusNumber(): Int {
        val bonusNumber = inputBonusNumber()
        checkBonusNumber(bonusNumber)
        return bonusNumber
    }

    fun checkBonusNumber(bonusNumber: Int) {
        if (bonusNumber !in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) {
            throw IllegalArgumentException(EXCEPTION_INVALID_CHARACTER)
        }
    }
}