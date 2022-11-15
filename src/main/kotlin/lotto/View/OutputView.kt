package lotto.View

import lotto.Model.Lotto
import lotto.constants.*

class OutputView {
    fun printStartMessage() {
        println(START_MESSAGE)
    }

    fun printBuyMessage(count: Int) {
        println(count.toString() + BUY_MESSAGE)
    }

    fun printLottoList(lottoList: List<Lotto>) {
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

    fun printWinningStatistics(ranksCount: List<Int>) {
        println(WINNING_STATISTICS)
        for (i in 0 until 5)
            println(RESULT_MESSAGES[i] + " - ${ranksCount[5 - i]}개")
    }

    fun printEarningsRate(earningRate: Double) {
        println("$EARNINGS_RATE$earningRate%입니다.")
    }

    fun printErrorMessage(error: String) {
        println(ERROR_MESSAGE + error)
    }
}