package lotto

import camp.nextstep.edu.missionutils.Console

class LottoProcess(private val seller: LottoSeller) {
    fun processLotto() {
        try {
            val purchasedLotto = processPurchasingLotto()
            val winningNumber = processGeneratingWinningNumber()
            val bonusNumber = processGeneratingBonusNumber(winningNumber)
            val result = processExtractingResult(purchasedLotto, winningNumber, bonusNumber)
        } catch (e: java.lang.IllegalArgumentException) {

        }
    }

    private fun processPurchasingLotto(): List<Lotto> {
        println(REQUEST_MONEY)
        val money = Console.readLine()
        val isErrorOccurred = InputValidator.validateMoney(money)

        require(isErrorOccurred == Error.NO_ERROR) {
            isErrorOccurred.errorText
        }
        val purchasedLotto=seller.sellLotto(money.toInt(), LOTTO_PRICE)
        
        println(PURCHASED_LOTTO_COUNT.format(purchasedLotto.size))
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
    ): Map<LottoStatus, Int> {
        val result = ResultExtractor.extractResult(purchasedLotto, winningNumber, bonusNumber)

        result.printResult()
        return result
    }

    private fun processCalculateProfit(usedMoney: Int, result: Map<LottoStatus, Int>){
        ResultExtractor.calcProfit(usedMoney.toDouble(), result)
    }

    private fun Map<LottoStatus, Int>.printResult() {
        LottoStatus.values().forEach { eachLottoStatus ->
            var eachStatusCount = 0
            this[eachLottoStatus]?.let { eachStatusCount = it }

            val msg = when (eachLottoStatus) {
                LottoStatus.FIFTH_PLACE -> "3개 일치 (5,000원) - %d개".format(eachStatusCount)
                LottoStatus.FOURTH_PLACE -> "4개 일치 (50,000원) - %d개".format(eachStatusCount)
                LottoStatus.THIRD_PLACE -> "5개 일치 (1,500,000원) - %d개".format(eachStatusCount)
                LottoStatus.SECOND_PLACE -> "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개".format(eachStatusCount)
                LottoStatus.FIRST_PLACE -> "6개 일치 (2,000,000,000원) - %d개".format(eachStatusCount)
                else -> return@forEach
            }
            println(msg)
        }
    }
}