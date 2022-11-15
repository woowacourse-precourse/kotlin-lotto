package lotto.domain

import lotto.utils.BONUS_INPUT_MSG
import lotto.utils.MONEY_INPUT_MSG
import lotto.utils.MONEY_UNIT
import lotto.utils.WINNING_INPUT_MSG
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame {
    fun run() {
        val inputView = InputView()
        val outputView = OutputView()

        println(MONEY_INPUT_MSG)
        val paidAmount = inputView.askUserMoney()

        val tryNumber = paidAmount / MONEY_UNIT
        val lottoNumbers = outputView.printLottoNumbers(tryNumber)

        println(WINNING_INPUT_MSG)
        val winningNumbers = inputView.askWinningNumbers()
        println(BONUS_INPUT_MSG)
        val bonusNumber = inputView.askBonusNumber(winningNumbers)

        val lotto = Lotto(winningNumbers)
        val winners = lotto.getWinnerList(lottoNumbers, bonusNumber)
        outputView.printWinnerList(winners)
        outputView.printEarningRate(winners, paidAmount)
    }
}