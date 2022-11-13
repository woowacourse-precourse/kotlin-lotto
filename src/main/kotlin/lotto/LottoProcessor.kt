package lotto

import camp.nextstep.edu.missionutils.Console
import java.text.DecimalFormat

class LottoProcessor(private val seller: LottoSeller) {
    fun processLotto() {
        try {
            val purchasedLotto = processPurchasingLotto()
            val winningNumber = processGeneratingWinningNumber()
            val bonusNumber = processGeneratingBonusNumber(winningNumber)
        } catch (e: java.lang.IllegalArgumentException) {
            println(e)
        }
    }

    private fun processPurchasingLotto(): List<Lotto> {
        println(REQUEST_MONEY)
        val money = Console.readLine()
        val isErrorOccurred = InputValidator.validateMoney(money)

        require(isErrorOccurred == Error.NO_ERROR) {
            isErrorOccurred.errorText
        }
        val purchasedLotto = seller.sellLotto(money.toInt(), LOTTO_PRICE)

        println(PURCHASED_LOTTO_COUNT.format(purchasedLotto.size))
        purchasedLotto.forEach { eachLotto ->
            eachLotto.printLottoNumbers()
        }
        return purchasedLotto
    }

    private fun processGeneratingWinningNumber(): List<Int> {
        println(REQUEST_WINNING_NUMBER)
        val winningNumber = Console.readLine().split(",")
        val isErrorOccurred = InputValidator.validateWinningNumber(winningNumber)

        require(isErrorOccurred == Error.NO_ERROR) {
            isErrorOccurred.errorText
        }
        return WinningNumberGenerator.generateWinningNumber(winningNumber)
    }

    private fun processGeneratingBonusNumber(winningNumber: List<Int>): Int {
        println(REQUEST_BONUS_NUMBER)
        val bonusNumber = Console.readLine()
        val isErrorOccurred = InputValidator.validateBonusNumber(bonusNumber, winningNumber)

        require(isErrorOccurred == Error.NO_ERROR) {
            isErrorOccurred.errorText
        }
        return WinningNumberGenerator.generateBonusNumber(bonusNumber)
    }
}