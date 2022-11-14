package lotto.service.dto

import lotto.domain.WinningResult
import lotto.domain.WinningStatistics
import java.math.BigDecimal

data class WinningStatisticsDto(val winningCounts: Map<WinningResult, Int>, val yields: BigDecimal) {

    fun winningCount(winningResult: WinningResult): Int {
        return winningCounts.getOrDefault(winningResult, 0)
    }

    companion object {
        fun createFrom(winningStatistics: WinningStatistics): WinningStatisticsDto {
            return WinningStatisticsDto(winningStatistics.winningCounts(), winningStatistics.yields())
        }
    }
}