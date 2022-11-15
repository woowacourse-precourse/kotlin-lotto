package lotto

import lotto.domain.LottoMachine
import lotto.domain.customer.Purchaser
import lotto.domain.store.Cacher

class World() {
    private val purchaser = Purchaser()
    private val lottoMachine = LottoMachine()
    private val printer = Printer()

    fun purchaseLotto() {
        val cacher = Cacher()

        printer.printEnterMoneyRequest()
        cacher.receiveMoney(purchaser.payMoney())
        purchaser.receivePurchasedLotteries(cacher.returnCreatedLotteries())

        printer.printNumberOfPurchaseLotteries(cacher.numberOfLotteries)
        printer.printPurchasedLotteries(purchaser.purchasedLotto)
    }

    fun publishWinningLotto() {
        printer.printEnterWinningNumbers()
        lottoMachine.publishWinningNumber()

        printer.printEnterBonusNumber()
        lottoMachine.publishBonusNumber()
    }

    fun showResult() {
        printer.printWinStatistics()
        printer.printLottoResult(purchaser.calculateRank(lottoMachine.winningNumbers, lottoMachine.bonusNumber))
        printer.printEarningRate(purchaser.calculateEarningRate())
    }
}
