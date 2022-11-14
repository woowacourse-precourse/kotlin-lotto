package lotto

import lotto.domain.LotteryChecker
import lotto.domain.Money
import lotto.domain.Publisher
import lotto.domain.WinningLottery
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame {
    fun run() {
        val money = Money(InputView.inputPurchasingAmount())
        val lottoTicket = Publisher().generateLottery(money)
        val winningLottery = WinningLottery(InputView.inputWinningLottery(), InputView.inputBonusNumber())

        lotteryChecker.checkLotteryNumber(winningLottery, lottoTicket)
        printResult(money, lotteryChecker)
    }

    private fun printResult(money: Money, lotteryChecker: LotteryChecker) {
        OutputView.printResult(lotteryChecker)
        OutputView.printRateOfProfit(money, lotteryChecker.getTotalWinnerPrice())
    }

    companion object {
        private val lotteryChecker = LotteryChecker()
    }
}
