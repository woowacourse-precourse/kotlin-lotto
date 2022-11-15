package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class WinningStatistics(lotteries: List<Lotto>, winningNumber: WinningNumber) {

    private val winningCounts = mutableMapOf<Rank, Int>()
    private val yields: BigDecimal

    init {
        initiateWinningCounts(lotteries, winningNumber)
        this.yields = calculateYields(lotteries)
    }

    private fun initiateWinningCounts(lotteries: List<Lotto>, winningNumber: WinningNumber) {
        Rank.values().forEach { winningCounts[it] = 0 }
        lotteries.forEach {
            winningCounts[it.rankWhenWinningNumberIs(winningNumber)] =
                winningCounts[it.rankWhenWinningNumberIs(winningNumber)]!! + 1
        }
    }

    private fun calculateYields(lotteries: List<Lotto>): BigDecimal =
        totalRevenue().multiply(BigDecimal(100)).divide(purchaseAmount(lotteries), 1, RoundingMode.HALF_EVEN)

    private fun totalRevenue() =
        winningCounts.entries.sumOf { BigDecimal(it.key.winnings).multiply(BigDecimal(it.value)) }

    private fun purchaseAmount(lotteries: List<Lotto>) =
        BigDecimal(lotteries.size).multiply(BigDecimal(LottoShop.lottoPrice()))

    fun winningCounts() = winningCounts.toMap()

    fun yields() = yields

}