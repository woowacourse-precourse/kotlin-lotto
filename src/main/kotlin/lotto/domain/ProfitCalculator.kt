package lotto.domain

class ProfitCalculator {
    fun calculateTotalPrize(ranks: List<Rank>, totalRanks: List<Int>): Long {
        var totalPrize = 0L
        for(index in totalRanks.indices) {
            totalPrize += ranks[index].getPrize(totalRanks[index])
        }
        return totalPrize
    }

    fun calculateYield(totalMoney: Int, totalPrize: Long): Double {
        return 0.0
    }
}