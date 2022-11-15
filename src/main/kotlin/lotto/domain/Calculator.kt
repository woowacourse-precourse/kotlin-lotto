package lotto.domain

import lotto.utils.ROUND_CRITERIA
import kotlin.math.pow
import kotlin.math.round

class Calculator {
    // 수익금을 계산한다.
    fun calcProfits(winners: List<Int>): Int {
        var profits = 0
        val rank = Ranking.values()
        for(i in rank.indices){
            profits += winners[i] * rank[i].prize
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