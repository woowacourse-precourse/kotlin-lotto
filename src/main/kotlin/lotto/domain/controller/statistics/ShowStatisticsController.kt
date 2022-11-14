package lotto.domain.controller.statistics

import lotto.domain.calculator.LottoCalculator
import lotto.domain.controller.Controller
import lotto.domain.model.statistics.WinningTotalStatistics
import lotto.ui.view.statistics.ShowStatisticsView

class ShowStatisticsController(
    private val showStatisticsView: ShowStatisticsView,
    private val winningTotalStatistics: WinningTotalStatistics
) : Controller() {

    override fun run() {
        printStatistics()
        finish()
    }

    private fun printStatistics() {
        showStatisticsView.printStatisticsTitleMessage()

        winningTotalStatistics.winningHistories.forEach { (lottoWinningResult, ticketCount) ->
            showStatisticsView.printWinningHistoryMessage(
                matchType = lottoWinningResult.matchType,
                matchNumberCount = lottoWinningResult.matchNumberCount,
                profit = lottoWinningResult.profit,
                matchTicketCount = ticketCount
            )
        }

        showStatisticsView.printTotalProfitRateMessage(winningTotalStatistics.totalProfitRate)
    }
}