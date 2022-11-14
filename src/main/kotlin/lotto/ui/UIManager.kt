package lotto.ui

import lotto.dto.DrawnNumbers

class UIManager(private val inputManager: InputManager, private val outputManager: OutputManager) {
    fun askPurchaseAmount(): Int {
        return inputManager.askPurchaseAmount()
    }

    fun askDrawnNumbers(): DrawnNumbers {
        return inputManager.askDrawnNumbers()
    }

    fun printWinningStatistics(winningList: List<Int>, earningsRate: Int) {
        outputManager.printWinningStatistics(winningList, earningsRate)
    }
}