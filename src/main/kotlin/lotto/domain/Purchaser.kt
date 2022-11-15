package lotto

import lotto.MatchedCount.*

private const val PLUS_COUNT = 1
private const val MIN_SAME_COUNT = 3

class Purchaser(private val purchasedLotto: List<Lotto>) {
    private val _rankResult = mutableMapOf<MatchedCount, Int>()
    val rankResult: Map<MatchedCount, Int> get() = _rankResult

    init {
        _rankResult.putAll(
            mapOf<MatchedCount, Int>(
                TRHEE to 0,
                FOUR to 0,
                FIVE to 0,
                FIVE_BONUS to 0,
                SIX to 0
            )
        )
    }

    fun determineRank(winningNumbers: List<Int>, bonusNumber: Int) {
        for (lotto in purchasedLotto) {
            val matchedCount = compareLotteries(lotto, winningNumbers, bonusNumber) ?: continue
            _rankResult[matchedCount] = _rankResult[matchedCount]!!.plus(PLUS_COUNT)
        }
    }

    private fun compareLottos(lotto: Lotto, winningNumbers: List<Int>, bonusNumber: Int): MatchedCount? {
        val sameNumberCount = lotto.checkWinningNumbersMatching(winningNumbers)
        if (sameNumberCount < MIN_SAME_COUNT) return null
        val bonusMatch = lotto.checkBonusNumberMatching(bonusNumber)
        return MatchedCount.matchRank(sameNumberCount, bonusMatch)
    }

    fun calculateEarningRate(money: Int): String {
        val totalEarning: Float = calculateTotalEarning().toFloat()
        val earningRate = totalEarning / money * 100
        return String.format("%.1f", earningRate)
    }

    private fun calculateTotalEarning(): Int {
        var totalEarning = 0
        rankResult.forEach { (matchedCount, count) ->
            if (count == 0) return@forEach
            totalEarning += matchedCount.prizeMoney
        }
        return totalEarning
    }
}
