package lotto.ui

class UIManager(private val inputManager: InputManager, private val outputManager: OutputManager) {
    fun askPurchaseAmount(): Int {
        return inputManager.askPurchaseAmount()
    }

    fun askDrawnNumbers(): Pair<List<Int>, Int> {
        return inputManager.askDrawnNumbers()
    }

    fun printWinningStatistics(winningList: List<Int>, earningsRate: Int) {
        outputManager.printWinningStatistics(winningList, earningsRate)
    }
}