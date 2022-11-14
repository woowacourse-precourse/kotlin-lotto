package lotto.ui.view.statistics

class ShowStatisticsView {

    fun printStatisticsTitleMessage() {
        println(OUTPUT_STATISTICS_TITLE_MESSAGE)
    }

    fun printWinningMatchMessage() {
        println(OUTPUT_STATISTICS_TITLE_MESSAGE)
    }


    companion object {
        private const val OUTPUT_STATISTICS_TITLE_MESSAGE = "당첨 통계\n---"
        private const val OUTPUT_WINNING_MATCH_NORMAL_MESSAGE = "%d개 일치 (%d원) - %d개"
        private const val OUTPUT_WINNING_MATCH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개"
        private const val OUTPUT_YIELD_MESSAGE = "총 수익률은 %.1f입니다."
    }
}