package lotto

import camp.nextstep.edu.missionutils.Console

class LottoProcessor(private val seller: LottoSeller, private val printer: Printer) {
    fun processLotto() {
        printer.printWord(REQUEST_MONEY)
        val inputMoney = processInputMoney()
        val purchasedLotto = seller.sellLotto(inputMoney)
        printer.printPurchasedLotto(purchasedLotto)
        printer.printWord(PURCHASED_LOTTO_COUNT.format(purchasedLotto.size))

        printer.printWord(REQUEST_WINNING_NUMBER)
        val winningNumber = processGeneratingWinningNumber()
        printer.printWord(REQUEST_BONUS_NUMBER)
        val bonusNumber = processGeneratingBonusNumber(winningNumber)

        val result = ResultExtractor.extractResult(purchasedLotto, winningNumber, bonusNumber)
        printer.printResult(result)
        val profit = ResultExtractor.calcProfit(inputMoney.toDouble(), result)
        printer.printWord(PROFIT_RESULT.format(profit))
    }

    private fun processInputMoney(): Int {
        val money = Console.readLine()
        val isErrorOccurred = InputValidator.validateMoney(money)

        require(isErrorOccurred == Error.NO_ERROR) {
            isErrorOccurred.errorText
        }
        return money.toInt()
    }

    private fun processGeneratingWinningNumber(): List<Int> {
        val winningNumber = Console.readLine().split(",")
        val isErrorOccurred = InputValidator.validateWinningNumber(winningNumber)

        require(isErrorOccurred == Error.NO_ERROR) {
            isErrorOccurred.errorText
        }
        return WinningNumberGenerator.generateWinningNumber(winningNumber)
    }

    private fun processGeneratingBonusNumber(winningNumber: List<Int>): Int {
        val bonusNumber = Console.readLine()
        val isErrorOccurred = InputValidator.validateBonusNumber(bonusNumber, winningNumber)

        require(isErrorOccurred == Error.NO_ERROR) {
            isErrorOccurred.errorText
        }
        return WinningNumberGenerator.generateBonusNumber(bonusNumber)
    }
}