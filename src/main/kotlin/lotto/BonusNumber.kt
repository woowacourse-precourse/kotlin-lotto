package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.Constant.Companion.emptyErrorMessage
import lotto.Constant.Companion.inputBonusMessage
import lotto.Constant.Companion.maxLottoNumber
import lotto.Constant.Companion.minLottoNumber
import lotto.Constant.Companion.notIntErrorMessage
import lotto.Constant.Companion.winningRangeErrorMessage

class BonusNumber {
    init {
        println(inputBonusMessage)
    }

    fun inputBonusNumber(): Int {
        val inputWinningNumber = readLine().trim()

        exception(inputWinningNumber)
        return inputWinningNumber.toInt()
    }

    fun exception(inputBonus: String) {
        if (inputBonus.isEmpty()) {
            println(emptyErrorMessage)
            throw IllegalArgumentException(emptyErrorMessage)
        }
        if (!isNumeric(inputBonus)) {
            println(notIntErrorMessage)
            throw IllegalArgumentException(notIntErrorMessage)
        }
        if (inputBonus.toInt() !in minLottoNumber..maxLottoNumber) {
            println(winningRangeErrorMessage)
            throw IllegalArgumentException(winningRangeErrorMessage)
        }
    }

    private fun isNumeric(str: String): Boolean {
        return str.chars().allMatch { Character.isDigit(it) }
    }
}