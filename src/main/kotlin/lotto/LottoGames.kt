package lotto

import lotto.domain.Calculator
import lotto.domain.CountRankings
import lotto.domain.RandomGenerator
import lotto.ui.InputUi
import lotto.ui.PrintUi

class LottoGames {
    private val inputUi = InputUi()
    private val printUi = PrintUi()
    private val calculator = Calculator()

    fun startGame() {
        val inputMoney = inputUi.inputMoney()
        printUi.printPurchaseNum(inputMoney / 1000)

        val lottos = RandomGenerator().createRandomlottos(inputMoney)
        printUi.printLottos(lottos)

        val winningNumber = inputUi.inputWinningNumbers()
        val bonusNumber = inputUi.inputBonusNumber()

        val rankingCounts = CountRankings().countRankings(winningNumber, bonusNumber, lottos)
        printUi.printWinningStats(rankingCounts)

        val sumPrizes = calculator.sumPrizes(rankingCounts)
        val yield = calculator.calculateYield(inputMoney, sumPrizes)
        printUi.printYield(`yield`)
    }
}