package lotto

class Controller() {
    private val inputCheck = InputCheck()
    private val inputConverter = InputConverter()
    private val lottoSeller = LottoSeller()
    private val lottoStatistics = LottoStatistics()
    private val messageMaker = MessageMaker()
    private val person = Person()

    fun run() {
        val purchaseCount = purchaseMoneyStep()
        val lottery = issueLotteryStep(purchaseCount)
        val winning = winningLotteryStep()
        val bonus = bonusStep(winning)
        statisticsStep(purchaseCount, lottery, winning, bonus)
    }

    private fun purchaseMoneyStep(): Int {
        messageMaker.purchaseInputPleaseMessage()
        val purchaseMoney = person.input()
        val purchaseInputCheckResult = inputCheck.checkInputLotteryPurchase(purchaseMoney)
        checkResultCompare(purchaseInputCheckResult)
        return lottoSeller.sellLottoCount(inputConverter.convertToInt(purchaseMoney))
    }

    private fun issueLotteryStep(count: Int): List<Lotto> {
        val lottery = lottoSeller.sellLottery(count)
        messageMaker.purchaseCountMessage(count)
        messageMaker.purchaseLotteryListMessage(lottery)
        return lottery
    }

    private fun winningLotteryStep(): List<Int> {
        messageMaker.winningLotteryInputMessage()
        val winningLottery = person.input()
        val winningLotteryCheckResult = inputCheck.checkInputWinningLottery(winningLottery)
        checkResultCompare(winningLotteryCheckResult)
        return inputConverter.convertSeparateComma(winningLottery)
    }

    private fun bonusStep(winning: List<Int>): Int {
        messageMaker.bonusInputMessage()
        val bonusNumber = person.input()
        val bonusNumberCheckResult = inputCheck.checkInputBonusInteger(bonusNumber, winning)
        checkResultCompare(bonusNumberCheckResult)
        return inputConverter.convertToInt(bonusNumber)
    }

    private fun statisticsStep(purchaseCount: Int, lottery: List<Lotto>, winning: List<Int>, bonus: Int) {
        messageMaker.winningStatisticsMessage()
        val lotteryResult = lottoStatistics.statisticsLotto(lottery, winning, bonus)
        messageMaker.statisticsMessage(lotteryResult)
        val yieldResult = lottoStatistics.yield(purchaseCount, lotteryResult)
        messageMaker.statisticsYieldMessage(yieldResult)
    }

    private fun checkResultCompare(errorType: MessageMaker.Error) {
        if (errorType != MessageMaker.Error.NON_ERROR) {
            MessageMaker.errorType = errorType
            throwError()
        }
    }

    private fun throwError() {
        throw IllegalArgumentException()
    }

}