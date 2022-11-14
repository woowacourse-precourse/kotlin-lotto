package lotto.ui

import lotto.domain.BonusNumber
import lotto.domain.Lotto

class UIManager(private val inputManager: InputManager, private val outputManager: OutputManager) {
    fun askPurchaseAmount(): Int {
        return inputManager.askPurchaseAmount()
    }

    fun askDrawnNumbers(): Pair<Lotto, BonusNumber> {
        return inputManager.askDrawnNumbers()
    }

    fun printWinningStatistics(winningList: List<Int>, earningsRate: Int) {
        outputManager.printWinningStatistics(winningList, earningsRate)
    }
}