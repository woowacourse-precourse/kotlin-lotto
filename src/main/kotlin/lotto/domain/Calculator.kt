package lotto.domain

import lotto.Prizes
import lotto.Ranks

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
            Ranks.FIRST.rank -> prize = Prizes.FIRST.money
            Ranks.SECOND.rank -> prize = Prizes.SECOND.money
            Ranks.THIRD.rank -> prize = Prizes.THIRD.money
            Ranks.FOURTH.rank -> prize = Prizes.FOURTH.money
            Ranks.FIFTH.rank -> prize = Prizes.FIFTH.money
        }
        return prize
    }

    fun calculateYield(purchase:Int,sumPrizes:Int):Double{
        return sumPrizes.toDouble()/purchase
    }
}