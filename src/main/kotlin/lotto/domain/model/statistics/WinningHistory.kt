package lotto.domain.model.statistics

import lotto.domain.model.statistics.enums.LottoMatchType

data class WinningHistory(
    var matchNumberCount: Int,
    var profit: Int,
    var matchTicketCount: Int,
    var matchType: LottoMatchType
) {
    companion object {
        fun emptyWinningHistory() =
            WinningHistory(matchNumberCount = 0, profit = 0, matchTicketCount = 0, matchType = LottoMatchType.NORMAL)
    }
}