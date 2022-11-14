package lotto.domain.model.statistics

import lotto.domain.model.statistics.enums.LottoWinningResult

data class WinningTotalStatistics(
    var winningHistories: MutableMap<LottoWinningResult, Int>,
    var totalProfitRate: Double
)