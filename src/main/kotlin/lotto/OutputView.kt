package lotto

class OutputView {
    companion object {
        const val START_MESSAGE = "구입금액을 입력해 주세요."
        const val BUY_MESSAGE = "개를 구매했습니다."
        const val WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
        const val BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
        const val WINNING_STATISTICS = "당첨 통계\n---"
        val RESULT_MESSAGES = listOf("3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)",
            "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)")
        const val EARNINGS_RATE = "총 수익률은 "
    }

    fun printStartMessage() {
        println(START_MESSAGE)
    }

    fun printBuyMessage(count: Int) {
        println(count.toString() + BUY_MESSAGE)
    }

    fun printLottoList(lottoList: List<Lotto>){
        for (element in lottoList) {
            println(element.getNumbers())
        }
    }

    fun printWinningNumberMessage() {
        println(WINNING_NUMBER_MESSAGE)
    }

    fun printBonusNumberMessage() {
        println(BONUS_NUMBER_MESSAGE)
    }

    fun printWinningStatistics(ranksCount: List<Int>){
        println(WINNING_STATISTICS)
        for (i in 0 until 5)
            println(RESULT_MESSAGES[i]+" - ${ranksCount[5-i]}개")
    }

    fun printEarningsRate(earningRate: Double){
        println("$EARNINGS_RATE$earningRate%입니다.")
    }
}