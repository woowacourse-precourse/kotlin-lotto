package lotto.domain

import lotto.util.Constant
import kotlin.math.roundToInt

class Statistic(private val ranks: List<Int>) {
    enum class Rank(val message: String, val money: Int, val index: Int) {
        FIFTH("3개 일치 (5,000원) -", 5000, 5),
        FOURTH("4개 일치 (50,000원) -", 50000, 4),
        THIRD("5개 일치 (1,500,000원) -", 1500000, 3),
        SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) -", 30000000, 2),
        FIRST("6개 일치 (2,000,000,000원) -", 2000000000, 1);
    }

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
