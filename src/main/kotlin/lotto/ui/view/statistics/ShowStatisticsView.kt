package lotto.ui.view.statistics

import lotto.domain.model.statistics.enums.LottoMatchType
import lotto.domain.model.statistics.WinningHistory

class ShowStatisticsView {

    fun printStatisticsTitleMessage() {
        println(OUTPUT_STATISTICS_TITLE_MESSAGE)
    }

    fun printWinningMatchMessage(winningHistory: WinningHistory) {
        val winningMatchMessageFormat = when (winningHistory.matchType) {
            LottoMatchType.NORMAL -> OUTPUT_WINNING_MATCH_NORMAL_MESSAGE
            LottoMatchType.BONUS -> OUTPUT_WINNING_MATCH_BONUS_MESSAGE
        }

        println(winningMatchMessageFormat.format(
            winningHistory.matchNumberCount,
            winningHistory.profit,
            winningHistory.matchTicketCount)
        )
    }

    fun printTotalProfitRateMessage(totalRate: Double) {
        println(OUTPUT_TOTAL_PROFIT_RATE_MESSAGE.format(totalRate))
    }

    companion object {
        private const val OUTPUT_STATISTICS_TITLE_MESSAGE = "당첨 통계\n---"
        private const val OUTPUT_WINNING_MATCH_NORMAL_MESSAGE = "%d개 일치 (%d원) - %d개"
        private const val OUTPUT_WINNING_MATCH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개"
        private const val OUTPUT_TOTAL_PROFIT_RATE_MESSAGE = "총 수익률은 %.1d입니다."
    }
}