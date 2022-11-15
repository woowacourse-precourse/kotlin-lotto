package lotto.domain

import lotto.Lotto
import lotto.ui.InputUi
import lotto.ui.PrintUi

class LottoGames {
    private val inputUi = InputUi()
    private val printUi = PrintUi()
    private val calculator = Calculator()

    fun startGame() {
        val inputMoney = purchaseLottos()
        val lottos = RandomGenerator().createRandomlottos(inputMoney)
        printUi.printLottos(lottos)

        val winningNumber = inputUi.inputWinningNumbers()
        val bonusNumber = inputUi.inputBonusNumber()

        calculateLottos(inputMoney, winningNumber, bonusNumber, lottos)
    }

    //돈 입력 및 구매 개수 출력
    private fun purchaseLottos(): Int {
        val inputMoney = inputUi.inputMoney()
        printUi.printPurchaseNum(inputMoney / 1000)
        return inputMoney
    }

    //등수를 구하고 총 당첨금 및 수익률 계산
    private fun calculateLottos(inputMoney: Int, winningNumber: List<Int>, bonusNumber: Int, lottos: List<Lotto>) {
        val rankingCounts = CountRankings().countRankings(winningNumber, bonusNumber, lottos)
        printUi.printWinningStats(rankingCounts)

        val sumPrizes = calculator.sumPrizes(rankingCounts)
        val yield = calculator.calculateYield(inputMoney, sumPrizes)
        printUi.printYield(`yield`)
    }

}