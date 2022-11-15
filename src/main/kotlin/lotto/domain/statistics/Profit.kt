package lotto.domain.statistics

import lotto.domain.prize.LottoPrize

class Profit(private val prizeCount: Map<LottoPrize, Int>, private val money: Int) {
    fun calculateRate(): String {
        val totalAmount = prizeCount.entries
            .sumOf { (lottoPrize, count) -> lottoPrize.winningAmount * count }
            .toFloat()
        return "%.1f".format(totalAmount / money * HUNDRED_NUMBER)
    }

    companion object {
        private const val HUNDRED_NUMBER = 100
    }
}