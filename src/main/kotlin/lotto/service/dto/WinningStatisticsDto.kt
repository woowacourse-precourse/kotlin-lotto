package lotto.service.dto

import lotto.domain.Rank
import lotto.domain.WinningStatistics
import java.math.BigDecimal

data class WinningStatisticsDto(val winningCounts: Map<Rank, Int>, val yields: BigDecimal) {

    fun winningCount(rank: Rank): Int {
        return winningCounts.getOrDefault(rank, 0)
    }

    companion object {
        fun createFrom(winningStatistics: WinningStatistics): WinningStatisticsDto {
            return WinningStatisticsDto(winningStatistics.winningCounts(), winningStatistics.yields())
        }
    }
}