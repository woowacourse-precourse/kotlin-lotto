package lotto.domain

import java.math.BigDecimal

class WinningStatistics(lotteries: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int) {

    private val winningCounts = mutableMapOf<WinningResult, Int>()
    private val yields: BigDecimal

    init {
        WinningResult.values().forEach { winningCounts[it] = 0 }
        lotteries.forEach {
            winningCounts[it.winningResult(winningNumbers, bonusNumber)] =
                winningCounts[it.winningResult(winningNumbers, bonusNumber)]!! + 1
        }
        this.yields = calculateYields()
    }

    companion object {
        private fun calculateYields(): BigDecimal {
            return BigDecimal("0")
        }
    }

}