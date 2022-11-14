package lotto.domain.model.statistics

data class WinningStatistics (
    val winningHistories: List<WinningHistory>,
    val totalProfitRate: Double
)