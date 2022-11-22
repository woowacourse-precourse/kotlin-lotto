package profit

import util.Constants
import util.Ranking

class ProfitCalculator {
    fun calcRateOfProfit(winningList: List<Int>, money: Int): Double {
        var profit = Constants.ZERO.constant

        for (i in Ranking.FIRST.ranking..Ranking.FIFTH.ranking) {
            profit += calcProfit(i) * winningList[i]
        }
        return (profit.toDouble() / money.toDouble()) * Constants.PERCENT.constant
    }

    private fun calcProfit(rank: Int): Int {
        when (rank) {
            Ranking.FIRST.ranking -> return Ranking.FIRST.profit
            Ranking.SECOND.ranking -> return Ranking.SECOND.profit
            Ranking.THIRD.ranking -> return Ranking.THIRD.profit
            Ranking.FOURTH.ranking -> return Ranking.FOURTH.profit
            Ranking.FIFTH.ranking -> return Ranking.FIFTH.profit
        }
        return Constants.ZERO.constant
    }
}