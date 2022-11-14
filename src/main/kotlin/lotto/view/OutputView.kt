package lotto.view

import lotto.utils.*
import kotlin.math.pow
import kotlin.math.round

class OutputView {
    // 당첨 내역을 출력한다.
    fun printWinnerList(winners: List<Int>) {
        println(WINNER_RESULT_MGS)
        println("$WINNER_5_MSG - ${winners[0]}개")
        println("$WINNER_4_MSG - ${winners[1]}개")
        println("$WINNER_3_MSG - ${winners[2]}개")
        println("$WINNER_2_MSG - ${winners[3]}개")
        println("$WINNER_1_MSG - ${winners[4]}개")
    }

    // 수익률을 출력한다.
    fun printEarningRate(winners: List<Int>, paidAmount: Int) {
        val profits = calcProfits(winners)
        val earningRate = calcEarningRate(profits, paidAmount)
        println("총 수익률은 ${earningRate}%입니다.")
    }

    // 수익금을 계산한다.
    fun calcProfits(winners: List<Int>): Int {
        val money = listOf(5000, 50_000, 1_500_000, 30_000_000, 2_000_000_000)
        var profits = 0
        for (i in winners.indices) {
            profits += money[i] * winners[i]
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