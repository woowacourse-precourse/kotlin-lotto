package lotto

import lotto.domain.Calculator
import lotto.domain.CountRankings
import lotto.domain.RandomGenerator
import lotto.ui.InputUi
import lotto.ui.PrintUi

fun main() {
    val inputUi = InputUi()
    val printUi = PrintUi()
    val calculator = Calculator()

    val inputMoney = inputUi.inputMoney()
    printUi.printPurchaseNum(inputMoney)

    val lottos = RandomGenerator().createRandomlottos(inputMoney)
    printUi.printLottos(lottos)

    val winningNumber = inputUi.inputWinningNumbers()
    val bonusNumber = inputUi.inputBonusNumber()

    val rankingCounts = CountRankings().countRankings(winningNumber,bonusNumber,lottos)
    printUi.printWinningStats(rankingCounts)

    val sumPrizes = calculator.sumPrizes(rankingCounts)
    val yield = calculator.calculateYield(inputMoney,sumPrizes)
    printUi.printYield(`yield`)
}
