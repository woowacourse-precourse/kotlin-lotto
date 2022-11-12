package lotto.domain

import lotto.util.Constant
import lotto.util.Rank
import kotlin.math.roundToInt

class Statistic(private val ranks: List<Int>) {
    private fun calculateProfitRate(lottoAmount: Int) = (addTotalWinningMoney() / lottoAmount.toLong().toDouble()) * 100

    private fun roundProfitRate(rate: Double) = (rate * 10).roundToInt().toDouble() / 10

    private fun addTotalWinningMoney(): Double {
        var sum = 0.0
        Rank.values().forEach { rank ->
            sum += (rank.money.toDouble() * (ranks[rank.index]).toDouble())
        }
        return sum
    }

    fun printWinningHistory() {
        println()
        println(TITLE)
        println(DASH)
        Rank.values().forEach { rank ->
            println("${rank.message} ${ranks[rank.index]}개")
        }
    }

    fun printYield(count: Int) = println(
        "총 수익률은 " +
                "${roundProfitRate(calculateProfitRate(count * Constant.LOTTO_PRICE))}" +
                "%입니다."
    )


    companion object {
        const val TITLE = "당첨 통계"
        const val DASH = "---"
    }
}
