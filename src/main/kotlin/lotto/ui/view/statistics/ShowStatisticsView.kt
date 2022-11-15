package lotto.ui.view.statistics

import lotto.domain.model.statistics.enums.LottoMatchType
import java.text.DecimalFormat

class ShowStatisticsView {

    fun printStatisticsTitleMessage() {
        println(OUTPUT_STATISTICS_TITLE_MESSAGE)
    }

    fun printWinningHistoryMessage(
        matchType: LottoMatchType,
        matchNumberCount: Int,
        profit: Int,
        matchTicketCount: Int
    ) {
        val winningMatchMessageFormat = when (matchType) {
            LottoMatchType.NORMAL -> OUTPUT_WINNING_MATCH_NORMAL_MESSAGE
            LottoMatchType.BONUS -> OUTPUT_WINNING_MATCH_BONUS_MESSAGE
        }

        println(
            winningMatchMessageFormat.format(
                matchNumberCount,
                profitFormat.format(profit),
                matchTicketCount
            )
        )
    }

    fun printTotalProfitRateMessage(totalProfitRate: Double) {
        println(OUTPUT_TOTAL_PROFIT_RATE_MESSAGE.format(profitRateFormat.format(totalProfitRate)))
    }

    companion object {
        private const val OUTPUT_STATISTICS_TITLE_MESSAGE = "\n당첨 통계\n---"
        private const val OUTPUT_WINNING_MATCH_NORMAL_MESSAGE = "%d개 일치 (%s원) - %d개"
        private const val OUTPUT_WINNING_MATCH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개"
        private const val OUTPUT_TOTAL_PROFIT_RATE_MESSAGE = "총 수익률은 %s%%입니다."
        private val profitFormat = DecimalFormat("#,###")
        private val profitRateFormat = DecimalFormat("#,###.0")
    }
}