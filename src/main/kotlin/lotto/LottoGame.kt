package lotto

import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame {

    fun run() {
        val money = Money(InputView.inputPurchasingAmount())
        val lottoTicket = Publisher().generateLottery(money)
        printGeneratedLotto(lottoTicket)
        val winningLottery = WinningLottery(InputView.inputWinningLottery(), InputView.inputBonusNumber())
        lotteryChecker.checkLotteryNumber(winningLottery, lottoTicket.second)
        printResult(money)
    }

    private fun printGeneratedLotto(lottoTicket: Pair<Long, List<Lotto>>) {
        OutputView.printLottoCount(lottoTicket.first)
        OutputView.printLottoNumber(lottoTicket.second)
    }

    private fun printResult(money: Money) {
        OutputView.printResult(lotteryChecker)
        OutputView.printRateOfProfit(money, lotteryChecker.getTotalWinnerPrice())
    }

    companion object {
        private val lotteryChecker = LotteryChecker()
    }
}
