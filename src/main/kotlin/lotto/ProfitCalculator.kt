package lotto

class ProfitCalculator {
    fun calcRateOfProfit(winningList: List<Int>, money: Int): Double {
        var profit = 0

        for (i in 1..5) {
            profit += calcProfit(i) * winningList[i]
        }
        return (profit.toDouble() / money.toDouble()) * 100
    }

    private fun calcProfit(rank: Int): Int {
        when (rank) {
            1 -> return 2_000_000_000
            2 -> return 30_000_000
            3 -> return 1_500_000
            4 -> return 50_000
            5 -> return 5000
        }
        return 0
    }
}