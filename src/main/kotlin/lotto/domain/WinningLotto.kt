package lotto.domain

import lotto.constants.Constant.Companion.LOTTO_SIZE
import lotto.constants.Constant.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.constants.Constant.Companion.MINIMUM_LOTTO_NUMBER
import lotto.constants.Constant.Companion.START_INDEX
import lotto.constants.Exception.Companion.EXCEPTION_DUPLICATED_NUMBER
import lotto.constants.Exception.Companion.EXCEPTION_INVALID_CHARACTER
import lotto.constants.Exception.Companion.EXCEPTION_INVALID_COUNT
import lotto.views.InputView.inputWinningNumber
import lotto.views.OutputView.printInputWinningNumbers
import java.lang.IllegalArgumentException

class WinningLotto {
    init {
        printInputWinningNumbers()
    }

    fun createWinningLotto(): Lotto {
        val winningNumbers = inputWinningNumber()
        validateWinningNumbers(winningNumbers)
        return Lotto(winningNumbers.sorted())
    }

    private fun validateWinningNumbers(winningNumbers: MutableList<Int>) {
        checkWinningNumbersSize(winningNumbers)
        checkDuplication(winningNumbers)
        checkWinningNumbersValue(winningNumbers)
    }

    private fun checkWinningNumbersSize(winningNumbers: MutableList<Int>) {
        if (winningNumbers.size != LOTTO_SIZE) {
            throw IllegalArgumentException(EXCEPTION_INVALID_COUNT)
        }
    }

    private fun checkDuplication(winningNumbers: MutableList<Int>) {
        if (winningNumbers.distinct().size != winningNumbers.size) {
            throw IllegalArgumentException(EXCEPTION_DUPLICATED_NUMBER)
        }
    }

    private fun checkWinningNumbersValue(winningNumbers: MutableList<Int>) {
        for (index in START_INDEX until LOTTO_SIZE) {
            if (winningNumbers[index] < MINIMUM_LOTTO_NUMBER || winningNumbers[index] > MAXIMUM_LOTTO_NUMBER) {
                throw IllegalArgumentException(EXCEPTION_INVALID_CHARACTER)
            }
        }
    }
}