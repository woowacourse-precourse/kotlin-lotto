package lotto.domain

class Calculator {
    fun sumPrizes(rankingCounts:HashMap<Int,Int>):Int {
        var sumPrizes = 0
        for (key in 1..5) {
            var prize = 0
            when (key) {
                1 -> prize = 2_000_000_000
                2 -> prize = 30_000_000
                3 -> prize = 1_500_000
                4 -> prize = 50_000
                5 -> prize = 5000
            }
            sumPrizes += prize * rankingCounts[key]!!
        }
        return sumPrizes
    }
}