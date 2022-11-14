package lotto.ui

import camp.nextstep.edu.missionutils.Console
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

    fun askDrawnNumbers(): Pair<List<Int>, Int> {
        val winningNumber = askWinningNumbers()
        println()
        val bonusNumber = askBonusNumber()
        inputValidator.validateDrawnNumber(winningNumber, bonusNumber)
        return winningNumber to bonusNumber
    }
}