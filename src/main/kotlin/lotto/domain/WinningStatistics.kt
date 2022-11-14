package lotto.domain

import java.math.BigDecimal

class WinningStatistics(lotteries: List<Lotto>, winningNumber: WinningNumber) {

    private val winningCounts = mutableMapOf<WinningResult, Int>()
    private val yields: BigDecimal

    init {
        WinningResult.values().forEach { winningCounts[it] = 0 }
        lotteries.forEach {
            winningCounts[winningNumber.winningResult(it)] =
                winningCounts[winningNumber.winningResult(it)]!! + 1
        }
        this.yields = calculateYields()
    }

    fun winningCounts() = winningCounts.toMap()

    fun yields() = yields

    companion object {
        private fun calculateYields(): BigDecimal {
            return BigDecimal("0")
        }
    }

}