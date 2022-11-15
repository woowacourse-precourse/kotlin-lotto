package lotto.domain

import kotlin.math.roundToLong

class ProfitCalculator {
    fun calculateTotalPrize(ranks: List<Rank>, totalRanks: List<Int>): Long {
        var totalPrize = 0L
        for (index in totalRanks.indices) {
            totalPrize += ranks[index].getPrize(totalRanks[index])
        }
        return totalPrize
    }

    fun calculateYield(totalPrize: Long, totalMoney: Int): String {
        val yieldPercentage = totalPrize.toDouble() / totalMoney.toDouble() * 100
        return "${"%.1f".format(yieldPercentage)}"
    }
}