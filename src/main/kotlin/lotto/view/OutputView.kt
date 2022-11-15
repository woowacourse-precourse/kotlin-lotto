package lotto.view

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
        val profits = calcProfits(winners)
        val earningRate = calcEarningRate(profits, paidAmount)
        println("총 수익률은 ${earningRate}%입니다.")
    }

    // 수익금을 계산한다.
    fun calcProfits(winners: List<Int>): Int {
        var profits = 0
        val rank = Ranking.values()
        for(i in rank.indices){
            profits += winners[i] * rank[i].price
        }
        return profits
    }

    // 수익률을 계산한다.
    fun calcEarningRate(profits: Int, paidAmount: Int): Double {
        val earningRate = (profits.toDouble() / paidAmount.toDouble()) * 100
        return roundDigit(earningRate, ROUND_CRITERIA)
    }

    // 소수점 n번째 자리에서 반올림 한 결과를 리턴한다.
    fun roundDigit(number: Double, exponent: Int): Double {
        return round(number * (10.0).pow(exponent - 1)) / (10.0).pow(exponent - 1)
    }
}