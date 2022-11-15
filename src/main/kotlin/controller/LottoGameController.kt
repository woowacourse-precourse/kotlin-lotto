package controller

import domain.LottoGame
import view.InputView.inputValidBonusNumber
import view.InputView.inputValidLottoNumber
import view.InputView.inputValidMoney
import view.OutputView.printLotteries
import view.OutputView.printStat

class LottoGameController {
    private lateinit var lottoGame: LottoGame
    fun startPurchaseLotteries() {
        lottoGame = LottoGame(inputMoney() / 1000)
        printLotteries(lottoGame.getLotteries())
        lottoGame.createWinningLotto(inputWinningNumber(), inputBonus())
    }

    fun makeResult() {
        val ranking = lottoGame.makeWinner().toMutableMap()
        val incomePercent: Double = lottoGame.makeRankPercent(ranking)
        printStat(ranking, incomePercent)
    }

    private fun inputBonus(): Int {
        return inputValidBonusNumber()
    }

    private fun inputMoney(): Int {
        return inputValidMoney()
    }

    private fun inputWinningNumber(): List<Int> {
        return inputValidLottoNumber()
    }
}
