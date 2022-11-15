package lotto.view

import lotto.domain.Calculator
import lotto.domain.Ranking
import lotto.utils.*
import kotlin.math.pow
import kotlin.math.round

class OutputView {
    // 당첨 내역을 출력한다.
    fun printWinnerList(winners: List<Int>) {
        println(WINNER_RESULT_MGS)
        println("$WINNER_5_MSG - ${winners[Ranking.FIFTH.ordinal]}개")
        println("$WINNER_4_MSG - ${winners[Ranking.FOURTH.ordinal]}개")
        println("$WINNER_3_MSG - ${winners[Ranking.THIRD.ordinal]}개")
        println("$WINNER_2_MSG - ${winners[Ranking.SECOND.ordinal]}개")
        println("$WINNER_1_MSG - ${winners[Ranking.FIRST.ordinal]}개")
    }

    // 수익률을 출력한다.
    fun printEarningRate(winners: List<Int>, paidAmount: Int) {
        val calculator = Calculator()
        val profits = calculator.calcProfits(winners)
        val earningRate = calculator.calcEarningRate(profits, paidAmount)
        println("총 수익률은 ${earningRate}%입니다.")
    }
}