package lotto.service.dto

import lotto.domain.WinningResult
import lotto.domain.WinningStatistics
import java.math.BigDecimal

class WinningStatisticsDto(winningStatistics: WinningStatistics) {

    private val winningCounts: Map<WinningResult, Int>
    private val yields: BigDecimal

    init {
        winningCounts = winningStatistics.winningCounts()
        yields = winningStatistics.yields()
    }

    fun winningCount(winningResult: WinningResult): Int {
        return winningCounts.getOrDefault(winningResult, 0)
    }

    fun yields() = yields

}