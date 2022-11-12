package lotto

import lottery.Lottery

fun main() {
    val lotto = Lottery()
    lotto.getPurchase()
    lotto.printQuickPick()

    lotto.getLotteryNumbers()
    lotto.getBonusNumber()

    lotto.printWinnings()
    lotto.printIncomeRatio()
}
