package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.InputValidator.validateBonusNumber
import lotto.InputValidator.validateWinningNumber

object WinningNumberGenerator {
    fun generateWinningNumber(winningNumber: List<String>): List<Int> = winningNumber.map { it.toInt() }

    fun generateBonusNumber(bonusNumber: String): Int = bonusNumber.toInt()
}