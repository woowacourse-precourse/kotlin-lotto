package lotto

import camp.nextstep.edu.missionutils.Console
import java.text.DecimalFormat

/**
 * 로또의 판매부터 모든 과정을 여기서 진행하게 된다.
 */
class LottoProcessor(private val seller: LottoSeller) {
    fun processLotto() {
        try {
            val purchasedLotto = processPurchasingLotto()
            val winningNumber = processGeneratingWinningNumber()
            val bonusNumber = processGeneratingBonusNumber(winningNumber)
            val result = processExtractingResult(purchasedLotto, winningNumber, bonusNumber)
            processCalculateProfit(purchasedLotto.size * LOTTO_PRICE, result)
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
        val purchasedLotto = seller.sellLotto(money.toInt())

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

    private fun processExtractingResult(
        purchasedLotto: List<Lotto>,
        winningNumber: List<Int>,
        bonusNumber: Int,
    ): Map<LottoPrice, Int> {
        val result = ResultExtractor.extractResult(purchasedLotto, winningNumber, bonusNumber)

        result.printResult()
        return result
    }

    private fun processCalculateProfit(usedMoney: Int, result: Map<LottoPrice, Int>) {
        val profit = ResultExtractor.calcProfit(usedMoney.toDouble(), result)
        println(PROFIT_RESULT.format(profit))
    }

    private fun Map<LottoPrice, Int>.printResult() {
        LottoPrice.values().forEach { eachLottoStatus ->
            var eachStatusCount = 0

            this[eachLottoStatus]?.let { eachStatusCount = it }
            val msg = when (eachLottoStatus) {
                LottoPrice.NONE -> return@forEach
                LottoPrice.SECOND_PLACE -> SECOND_PLACE_MSG.format(eachStatusCount)
                else -> PLACE_MSG.format(eachLottoStatus.catchCount, eachLottoStatus.price.withComma(), eachStatusCount)
            }
            println(msg)
        }
    }

    private fun Int.withComma() = DecimalFormat("#,###").format(this)
}