package lotto.model

import lotto.model.Buyer.amount
import lotto.util.Constant.FIFTH
import lotto.util.Constant.FIFTH_BONUS
import lotto.util.Constant.FOURTH
import lotto.util.Constant.MISS
import lotto.util.Constant.SIXTH
import lotto.util.Constant.THIRD

class LottoReward() {
    fun matchReward(count: String): Any {
        return when (count) {
            THIRD -> Reward.FIFTH
            FOURTH -> Reward.FOURTH
            FIFTH -> Reward.THIRD
            FIFTH_BONUS -> Reward.SECOND
            SIXTH -> Reward.FIRST
            else -> MISS
        }
    }

    fun calcProfit(amount: Int, results: Map<Reward, Int>): String {
        val result = results.filterValues { it > 0 }
        var total = 0.0
        for ((reward, count) in result) {
            val prize = reward.prize.split(",").joinToString("").toDouble()
            total += (prize * count)
        }
        val profit = (total / amount) * 100
        return String.format("%,.1f", profit)
    }
}