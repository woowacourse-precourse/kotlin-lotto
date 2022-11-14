package lotto.domain.model.statistics

data class WinningTotalStatistics (
    val winningHistories: List<WinningHistory>,
    val totalProfitRate: Double
) {
    companion object {
        fun emptyWinningTotalStatistics() = WinningTotalStatistics(winningHistories = listOf(), totalProfitRate = 0.0)
    }
}