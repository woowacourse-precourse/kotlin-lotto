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

        val inputMoney = purchaseLottos()

        //로또 생성
        val lottos = RandomGenerator().createRandomlottos(inputMoney)
        printUi.printLottos(lottos)

        //입력받기
        val winningNumber = inputUi.inputWinningNumbers()
        val bonusNumber = inputUi.inputBonusNumber()

        //랭킹 구하고 출력
        val rankingCounts = CountRankings().countRankings(winningNumber, bonusNumber, lottos)
        printUi.printWinningStats(rankingCounts)

        //총 당첨금, 수익률 계산
        val sumPrizes = calculator.sumPrizes(rankingCounts)
        val yield = calculator.calculateYield(inputMoney, sumPrizes)
        printUi.printYield(`yield`)
    }
    //돈 입력 및 구매 개수 출력
    private fun purchaseLottos():Int{
        val inputMoney = inputUi.inputMoney()
        printUi.printPurchaseNum(inputMoney / 1000)
        return inputMoney
    }

}