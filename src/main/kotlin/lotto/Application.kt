package lotto

import lotto.service.LottoService
import lotto.userinterface.UserInterface

fun main() {
    try {
        val purchaseAmount = UserInterface.askPurchaseAmount()
        val lotteries = LottoService.purchaseLotteries(purchaseAmount)
        UserInterface.showPurchaseResult(lotteries)

        val winningNumbers = UserInterface.askWinningNumbers()
        val bonusNumber = UserInterface.askBonusNumberNotIn(winningNumbers)
        val winningStatistics = LottoService.getWinningStatistics(winningNumbers, bonusNumber)
        UserInterface.showWinningStatistics(winningStatistics)
    } catch (e: Exception) {
        println(e.message)
    }

}
