package lotto.domain

import lotto.view.InputView
import lotto.view.OutputView

class Game {

    private val lottoStaff = LottoStaff()
    private val inputView = InputView()
    private val outputView = OutputView()
    private val prizeResult = PrizeResult()

    fun start() {
        val purchasePrice = inputView.getPurchasePrice()
        val lottoCount = lottoStaff.countLotto(purchasePrice)
        val lotteries = lottoStaff.generateLotteries(lottoCount)

        outputView.printLotteriesCount(lotteries.size)
        outputView.printLotteriesNumbers(lotteries)

        val winningNumbers = inputView.getWinningLottoNumbers()
        val bonusNumber = inputView.getBonusNumber(winningNumbers)

        lotteries.forEach { lotto ->
            val matchNumberCount = lottoStaff.countMatchingNumber(lotto.getNumbers(), winningNumbers.getNumbers())
            val isBonusMatch = lottoStaff.checkBonusNumber(lotto.getNumbers(), bonusNumber)
            val prize = lottoStaff.checkPrize(matchNumberCount, isBonusMatch)
            prizeResult.updatePrizeResult(prize)
        }

        outputView.printLottoPrizeResult(prizeResult)
        outputView.printProfitPercentage(lottoStaff.getProfit(prizeResult.getTotalPrizeMoney(), purchasePrice))
    }
}