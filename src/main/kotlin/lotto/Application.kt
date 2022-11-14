package lotto

fun main() {
    val printer = Printer()
    val cacher = Cacher()
    val ticketingMachine = TicketingMachine()
    val lottoMachine = LottoMachine()
    val purchaser = Purchaser()

    printer.printEnterMoneyRequest()
    val money: Int = cacher.enterPurchaseMoney()
    val numberOfLotto = cacher.calculateNumberOfLottos(money)

    val purchasedLottos = ticketingMachine.createLottoNumbers(numberOfLotto)
    printer.printNumberOfPurchaseLottos(numberOfLotto)
    printer.printPurchasedLottos(purchasedLottos)

    printer.printEnterWinningNumbers()
    lottoMachine.publishWinningNumber()

    printer.printEnterBonusNumber()
    lottoMachine.publishBonusNumber()

    purchaser.determineRank(purchasedLottos, lottoMachine.winningNumbers, lottoMachine.bonusNumber)
    printer.printWinStatistics()
    printer.printLottoResult(purchaser.rankResult)
    printer.printEarningRate(purchaser.calculateEarningRate(money))
}
