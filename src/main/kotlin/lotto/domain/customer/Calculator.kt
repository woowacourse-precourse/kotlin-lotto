package lotto.domain.customer

import lotto.domain.Lotto

private const val PLUS_COUNT = 1
private const val MIN_SAME_COUNT = 3
private const val ROUNDING_UNIT = "%.1f"
private const val ZERO = 0

class Calculator() {
    private val rankResult = mutableMapOf<MatchedCount, Int>()

    init {
        rankResult.putAll(
            mapOf<MatchedCount, Int>(
                MatchedCount.THREE to ZERO,
                MatchedCount.FOUR to ZERO,
                MatchedCount.FIVE to ZERO,
                MatchedCount.FIVE_BONUS to ZERO,
                MatchedCount.SIX to ZERO
            )
        )
    }

    fun calculateRank(
        purchasedLotteries: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Map<MatchedCount, Int> {
        for (lotto in purchasedLotteries) {
            val matchedCount = compareLotteries(lotto, winningNumbers, bonusNumber) ?: continue
            rankResult[matchedCount] = rankResult[matchedCount]!!.plus(PLUS_COUNT)
        }
        return rankResult
    }

    private fun compareLotteries(lotto: Lotto, winningNumbers: List<Int>, bonusNumber: Int): MatchedCount? {
        val sameCount = lotto.checkWinningNumbersMatching(winningNumbers)
        if (sameCount < MIN_SAME_COUNT) return null
        val bonusMatch = lotto.checkBonusNumberMatching(bonusNumber)
        return MatchedCount.matchRank(sameCount, bonusMatch)
    }

    fun calculateEarningRate(paidMoney: Int): String {
        val totalEarning: Float = getEarningSum().toFloat()
        val earningRate = totalEarning / paidMoney * 100
        return String.format(ROUNDING_UNIT, earningRate)
    }

    private fun getEarningSum(): Int {
        var totalEarning = 0
        rankResult.forEach { (matchedCount, count) ->
            if (count == ZERO) return@forEach
            totalEarning += matchedCount.prizeMoney
        }
        return totalEarning
    }
}
