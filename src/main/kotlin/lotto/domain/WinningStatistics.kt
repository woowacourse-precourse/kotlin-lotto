package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class WinningStatistics(lotteries: List<Lotto>, winningNumber: WinningNumber) {

    private val winningCounts = mutableMapOf<WinningResult, Int>()
    private val yields: BigDecimal

    init {
        WinningResult.values().forEach { winningCounts[it] = 0 }
        lotteries.forEach {
            winningCounts[winningNumber.winningResult(it)] =
                winningCounts[winningNumber.winningResult(it)]!! + 1
        }
        this.yields = totalRevenue().multiply(BigDecimal(100))
            .divide(BigDecimal(lotteries.size).multiply(BigDecimal(LottoShop.lottoPrice())), 1, RoundingMode.HALF_EVEN)
    }

    private fun totalRevenue() =
        winningCounts.entries.sumOf { BigDecimal(it.key.winnings).multiply(BigDecimal(it.value)) }

    fun winningCounts() = winningCounts.toMap()

    fun yields() = yields

}