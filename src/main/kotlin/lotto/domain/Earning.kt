package lotto.domain

import lotto.util.Constant
import lotto.util.Rank
import kotlin.math.roundToInt

class Earning(private val ranks: List<Int>) {
    private fun calculateRate(lottoAmount: Int) = (calculateEarning() / lottoAmount.toDouble()) * Constant.PERCENTAGE

    private fun roundRate(rate: Double) =
        (rate * Constant.DECIMAL_PLACE).roundToInt().toDouble() / Constant.DECIMAL_PLACE

    private fun calculateEarning(): Double {
        var sum = 0.0
        Rank.values().forEach { index ->
            sum += (index.money.toDouble() * (ranks[index.rank]).toDouble())
        }
        return sum
    }

    fun getRate(count: Int) = roundRate(calculateRate(count * Constant.LOTTO_PRICE))
}