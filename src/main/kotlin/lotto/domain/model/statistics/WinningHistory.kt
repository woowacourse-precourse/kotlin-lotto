package lotto.domain.model.statistics

data class WinningHistory(
    val matchNumberCount: Int,
    val profit: Int,
    val matchTicketCount: Int,
    val matchType: LottoMatchType
) {
    companion object {
        fun emptyWinningHistory() = WinningHistory(matchNumberCount = -1, profit = -1, matchTicketCount = -1, matchType = LottoMatchType.NORMAL)
    }
}