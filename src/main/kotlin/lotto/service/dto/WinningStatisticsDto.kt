package lotto.service.dto

import lotto.domain.Rank
import lotto.domain.WinningStatistics
import java.math.BigDecimal

data class WinningStatisticsDto(val winningCounts: Map<Rank, Int>, val yields: BigDecimal) {

    fun winningCount(rank: Rank): Int = winningCounts.getOrDefault(rank, 0)

    companion object {
        fun createFrom(winningStatistics: WinningStatistics): WinningStatisticsDto =
            WinningStatisticsDto(winningStatistics.winningCounts(), winningStatistics.yields())
    }
}