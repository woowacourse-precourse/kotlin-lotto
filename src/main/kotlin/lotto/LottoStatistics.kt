package lotto

import kotlin.math.round

class LottoStatistics {
    fun statisticsLotto(
        lotteryTickets: List<Lotto>, winning: List<Int>, bonus: Int,
    ): List<Int> {
        val result = mutableListOf(0, 0, 0, 0, 0, 0)
        lotteryTickets.forEach { result[it.matchResult(winning, bonus).index]++ }
        return result.subList(0, 5)
    }

    fun yield(lotteryNum: Int, statistics: List<Int>): Double {
        var sum = 0.0
        for (i in statistics.indices) {
            sum += when (i) {
                MatchResult.THREE.index -> MatchResult.THREE.money * statistics[i]
                MatchResult.FOUR.index -> MatchResult.FOUR.money * statistics[i]
                MatchResult.FIVE.index -> MatchResult.FIVE.money * statistics[i]
                MatchResult.BONUS.index -> MatchResult.BONUS.money * statistics[i]
                else -> MatchResult.SIX.money * statistics[i]
            }
        }
        val statisticsResult: Double = sum / (lotteryNum * LottoSeller.LOTTO_SELL_PRICE) * 100
        return round(statisticsResult * 10) / 10
    }
}