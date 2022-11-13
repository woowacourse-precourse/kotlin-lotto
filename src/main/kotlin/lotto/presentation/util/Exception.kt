package lotto.presentation.util

import lotto.domain.Lotto
import lotto.presentation.util.Constant.bonusOverlapErrorMessage
import lotto.presentation.util.Constant.costNotRegularErrorMessage
import lotto.presentation.util.Constant.purchaseAmountErrorMessage
import lotto.presentation.util.Constant.winningOverlapAndWrongErrorMessage
import lotto.presentation.util.Constant.winningRangeErrorMessage
import lotto.presentation.util.Constant.wrongBonusNumberErrorMessage
import lotto.presentation.util.Constant.wrongWinningNumberErrorMessage


fun String.inputTypeException() {
    try {
        this.toInt()

    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(purchaseAmountErrorMessage)
    }
}

fun String.inputMoneyException(): Int {
    if (this.toInt() % 1000 == 0) return this.toInt()
    throw IllegalArgumentException(costNotRegularErrorMessage)
}


fun inputWinningNumberException(winningNumber: List<String>): List<Int> {
    try {
        Lotto(winningNumber.map { it.inputLottoNumberException() })
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException(winningOverlapAndWrongErrorMessage)
    }
    return winningNumber.map { it.inputLottoNumberException() }
}

fun List<String>.inputLottoNumberTypeException() {
    try {
        this.map {
            it.toInt()
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(wrongWinningNumberErrorMessage)

    }
}

fun String.inputLottoNumberException(): Int {
    try {
        if (this.toInt() <= 0 || this.toInt() > 45) {
            throw IllegalArgumentException(winningRangeErrorMessage)
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(winningRangeErrorMessage)
    }
    return this.toInt()
}

fun inputWinningBonusNumberException(winningNumber: List<Int>, bonusNumber: Int) {
    if (winningNumber.contains(bonusNumber)) throw IllegalArgumentException(bonusOverlapErrorMessage)
}

fun String.inputLottoNumberTypeException() {
    try {
        this.map {
            it.code
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(wrongBonusNumberErrorMessage)

    }
}