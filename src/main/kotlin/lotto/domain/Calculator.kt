package lotto.domain

class Calculator {
    fun sumPrizes(rankingCounts:HashMap<Int,Int>):Int {
        var sumPrizes = 0
        for (key in 1..5) {
            sumPrizes += prizeMoney(key) * rankingCounts[key]!!
        }
        return sumPrizes
    }

    private fun prizeMoney(rank:Int): Int {
        var prize = 0
        when (rank) {
            1 -> prize = 2_000_000_000
            2 -> prize = 30_000_000
            3 -> prize = 1_500_000
            4 -> prize = 50_000
            5 -> prize = 5000
        }
        return prize
    }

    fun calculateYield(purchase:Int,sumPrizes:Int):Double{
        return sumPrizes.toDouble()/purchase
    }
}