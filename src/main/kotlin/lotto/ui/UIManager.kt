package lotto.ui

import lotto.domain.BonusNumber
import lotto.domain.Lotto
import lotto.domain.LottoList

class UIManager(private val inputManager: InputManager, private val outputManager: OutputManager) {
    fun askPurchaseAmount(): Int {
        return inputManager.askPurchaseAmount()
    }

    fun printPurchaseNumber(number: Int) {
        println()
        outputManager.printPurchaseNumber(number)
    }

    fun askDrawnNumbers(): Pair<Lotto, BonusNumber> {
        return inputManager.askDrawnNumbers()
    }

    fun printWinningStatistics(winningList: List<Int>, earningsRate: Double) {
        outputManager.printWinningStatistics(winningList, earningsRate)
    }

    fun printUserLotto(userLotto: LottoList) {
        outputManager.printUserLotto(userLotto)
    }
}