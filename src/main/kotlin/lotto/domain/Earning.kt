package lotto.domain

import lotto.util.Constant
import lotto.util.Rank
import kotlin.math.roundToInt

class Earning(private val ranks: List<Int>) {
    private fun calculateRate(lottoAmount: Int) = (calculateTotal() / lottoAmount.toDouble()) * Constant.PERCENTAGE

    private fun roundRate(rate: Double) =
        (rate * Constant.DECIMAL_PLACE).roundToInt().toDouble() / Constant.DECIMAL_PLACE

    private fun calculateTotal(): Double {
        var sum = 0.0
        Rank.values().forEach { rank ->
            sum += (rank.money.toDouble() * (ranks[rank.index]).toDouble())
        }
        return sum
    }

    fun getRate(count: Int) = roundRate(calculateRate(count * Constant.LOTTO_PRICE))
}