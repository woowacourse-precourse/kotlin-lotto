package lotto

object Printer {
    fun printAmountMessage() {
        println(ENTER_BUY_AMOUNT)
    }

    fun printLottoCountMessage(count: Int) {
        println(BOUGHT_COUNT.format(count))
    }

    fun printBoughtLottoList(lotteries: List<List<Int>>) {
        lotteries.forEach { list ->
            println(list)
        }
    }

    fun printWinningNumberMessage() {
        println(ENTER_WINNING_NUMBER)
    }

    fun printBonusNumberMessage() {
        println(ENTER_BONUS_NUMBER)
    }

    fun printWinStaticMessage() {
        println(WINNING_STATICS)
    }

    fun printLottoResult(result: List<LottoResultState>) {
        println(
            CORRECT_THREE.format(result.count { it == LottoResultState.FIFTH }) +
            CORRECT_FOUR.format(result.count { it == LottoResultState.FOURTH }) +
            CORRECT_FIVE.format(result.count { it == LottoResultState.THIRD }) +
            CORRECT_FIVE_AND_BONUS.format(result.count { it == LottoResultState.SECOND }) +
            CORRECT_SIX.format(result.count { it == LottoResultState.FIRST })
        )
    }

    fun printYield(yieldPercentage: String) {
        println(TOTAL_YIELD.format(yieldPercentage))
    }

    fun printError(errorMessage: String) {
        println(ERROR_MESSAGE.format(errorMessage))
    }

}