package lotto.domain

import java.math.BigDecimal

class WinningStatistics(lotteries: List<Lotto>, winningNumber: WinningNumber) {

    private val winningCounts = mutableMapOf<WinningResult, Int>()
    private val yields: BigDecimal

    init {
        WinningResult.values().forEach { winningCounts[it] = 0 }
        lotteries.forEach {
            winningCounts[it.winningResult(winningNumber)] =
                winningCounts[it.winningResult(winningNumber)]!! + 1
        }
        this.yields = calculateYields()
    }

    companion object {
        private fun calculateYields(): BigDecimal {
            return BigDecimal("0")
        }
    }

}