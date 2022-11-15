package lotto.domain.model.statistics

import lotto.domain.model.statistics.enums.LottoWinningResult

data class WinningTotalStatistics(
    var winningHistories: MutableMap<LottoWinningResult, Int>,
    var totalProfitRate: Double
) {
    companion object {
        val emptyWinningHistories = mutableMapOf(
            LottoWinningResult.FIFTH to 0,
            LottoWinningResult.FOURTH to 0,
            LottoWinningResult.THIRD to 0,
            LottoWinningResult.SECOND to 0,
            LottoWinningResult.FIRST to 0,
        )
    }
}