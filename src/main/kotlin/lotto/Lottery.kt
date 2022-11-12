package lotto

class Lottery(
    private val computer: Computer,
    private val calculator: Calculator,
    private val buyer: Buyer,
    private val printer: Printer
) {
    private var amount: Int = 0

    fun start() {
        purchaseLotto()
        getWinningNumber()
        getBonusNumber()
        getLottoResult()
    }

    private fun purchaseLotto() {
        printer.printAmountMessage()
        amount = buyer.enterAmount()
        val lottoCount = calculator.getLottoCount(amount)
        printer.printLottoCountMessage(lottoCount)
        computer.makeLotteries(lottoCount)
        printer.printBoughtLottoList(computer.lotteries)
    }

    private fun getWinningNumber() {
        printer.printWinningNumberMessage()
        buyer.enterWinningNumber()
    }

    private fun getBonusNumber() {
        printer.printBonusNumberMessage()
        buyer.enterBonusNumber()
    }

    private fun getLottoResult() {
        printer.printWinStaticMessage()
        calculator.getLottoResult(computer.lotteries, buyer.winningNumbers, buyer.bonusNumber)
        printer.printLottoResult(calculator.lottoResults)
        val yieldPercentage = calculator.getYield(amount)
        printer.printYield(yieldPercentage)
    }

    companion object {
        fun printAndThrowException(errorMessage: String) {
            Printer.printError(errorMessage)
            throw IllegalArgumentException(errorMessage)
        }

    }
}