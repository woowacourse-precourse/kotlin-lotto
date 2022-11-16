package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.domain.BonusNumber
import lotto.domain.Lotto
import lotto.enum.InputString

class InputManager(private val inputValidator: InputValidator) {
    fun askPurchaseAmount(): Int {
        InputString.ASK_PURCHASE_AMOUNT.print()
        val input = Console.readLine()
        inputValidator.validatePurchaseAmount(input)
        return input.toInt()
    }

    private fun askWinningNumbers(): List<Int> {
        InputString.ASK_WINNING_NUMBER.print()
        val input = Console.readLine().split(',')
        inputValidator.validateWinningNumbers(input)
        return input.map { it.toInt() }
    }

    private fun askBonusNumber(): Int {
        InputString.ASK_BONUS_NUMBER.print()
        val input = Console.readLine()
        inputValidator.validateBonusNumber(input)
        return input.toInt()
    }

    fun askDrawnNumbers(): Pair<Lotto, BonusNumber> {
        val winningNumbers = askWinningNumbers()
        println()
        val winningLotto = Lotto(winningNumbers)
        val bonusNumber = BonusNumber(askBonusNumber())
        println()
        inputValidator.validateDrawnNumber(winningNumbers, bonusNumber)
        return winningLotto to bonusNumber
    }
}