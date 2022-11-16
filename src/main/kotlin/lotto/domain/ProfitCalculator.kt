package lotto.domain

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
        val format = "%,.1f"
        return "${format.format(yieldPercentage)}"
    }
}