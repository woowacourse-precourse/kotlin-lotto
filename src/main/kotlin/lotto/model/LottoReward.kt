package lotto.model

import lotto.model.Buyer.amount

class LottoReward() {
    fun matchReward(count: String): Any {
        return when (count) {
            "3" -> Reward.FIFTH
            "4" -> Reward.FOUR
            "5" -> Reward.THIRD
            "5bonus" -> Reward.SECOND
            "6" -> Reward.FIRST
            else -> "NONE"
        }
    }

    fun calcProfit(results: Map<Reward, Int>): Float {
        val result = results.filterValues { it > 0 }
        var total = 0.0
        for ((reward, count) in result) {
            val prize = reward.prize.split(",").joinToString("").toDouble()
            total += (prize * count)
        }
        val profit = (total / amount) * 100
        return String.format("%,.1f",profit).toFloat()
    }
}