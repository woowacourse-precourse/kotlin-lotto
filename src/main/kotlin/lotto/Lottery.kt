package lotto

class Lottery(
    private val computer: Computer,
    private val calculator: Calculator,
    private val buyer: Buyer,
    private val printer: Printer
) {
    fun start() {
        purchaseLotto()
        getWinningNumber()
        getBonusNumber()
        getLottoResult()
    }

    private fun purchaseLotto() {
        printer.printAmountMessage()
        val amount = buyer.enterAmount()
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
    }

    companion object {
        fun printAndThrowException(errorMessage: String) {
            Printer.printError(errorMessage)
            throw IllegalArgumentException(errorMessage)
        }

    }
}