package lotto

import lotto.utils.MONEY_UNIT
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame {
    fun run() {
        val inputView = InputView()
        val paidAmount = inputView.askUserMoney()
        val tryNumber = paidAmount / MONEY_UNIT
        val lottoNumbers = inputView.getLottoNumbers(tryNumber)

        val winningNumbers = inputView.askWinningNumbers()
        val bonusNumber = inputView.askBonusNumber()

        val lotto = Lotto(winningNumbers)
        val winners = lotto.getWinnerList(lottoNumbers, bonusNumber)

        val outputView = OutputView()
        outputView.printWinnerList(winners)
        outputView.printEarningRate(winners, paidAmount)
    }
}