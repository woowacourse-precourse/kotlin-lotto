package lotto.presentation.util

import lotto.domain.Lotto


fun String.inputTypeException() {
    try {
        this.toInt()

    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 구입 금액을 잘못입력하셨습니다.")
    }
}

fun String.inputMoneyException(): Int {
    if (this.toInt() % 1000 == 0) return this.toInt()
    throw IllegalArgumentException("[ERROR] 숫자가 나누어 떨어지지 않습니다.")
}


fun inputWinningNumberException(winningNumber: List<String>): List<Int> {
    try {
        Lotto(winningNumber.map { it.inputLottoNumberException() })
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("[ERROR] 당첨 번호의 개수가 잘못 입력되었거나 중복되었습니다.")
    }
    return winningNumber.map { it.inputLottoNumberException() }
}

fun List<String>.inputLottoNumberTypeException() {
    try {
        this.map {
            it.toInt()
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 당첨 번호를 잘못입력하셨습니다.")

    }
}

fun String.inputLottoNumberException(): Int {
    try {
        if (this.toInt() <= 0 || this.toInt() > 45) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
    return this.toInt()
}

fun inputWinningBonusNumberException(winningNumber: List<Int>, bonusNumber: Int) {
    if (winningNumber.contains(bonusNumber)) throw IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복되었습니다.")
}

fun String.inputLottoNumberTypeException() {
    try {
        this.map {
            it.code
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 보너스 번호를 잘못입력하셨습니다.")

    }
}