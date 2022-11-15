package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import java.lang.IllegalArgumentException

class Lottery(
    private val computer: Computer
) {
    private val buyer = Buyer
    private val calculator = Calculator
    private val printer = Printer
    private var amount: Int = 0

    fun start() {
        purchaseLotto()
        getWinningNumber()
        getBonusNumber()
        getLottoResult()
    }

    private fun purchaseLotto() {
        printer.printAmountMessage()
        amount = buyer.enterAmount(readLine())
        val lottoCount = calculator.getLottoCount(amount)
        printer.printLottoCountMessage(lottoCount)
        computer.makeLotteries(lottoCount)
        printer.printBoughtLottoList(computer.lotteries)
    }

    private fun getWinningNumber() {
        printer.printWinningNumberMessage()
        buyer.enterWinningNumber(readLine())
    }

    private fun getBonusNumber() {
        printer.printBonusNumberMessage()
        buyer.enterBonusNumber(readLine())
    }

    private fun getLottoResult() {
        printer.printWinStaticMessage()
        calculator.getLottoResult(computer.lotteries, buyer.winningNumbers, buyer.bonusNumber)
        printer.printLottoResult(calculator.lottoResults)
        val yieldPercentage = calculator.getYield(amount)
        printer.printYield(yieldPercentage)
    }

    companion object {
        fun throwException(errorMessage: String) {
            throw IllegalArgumentException(errorMessage)
        }
    }
}