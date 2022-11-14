package lotto.domain.controller.statistics

import lotto.domain.controller.Controller
import lotto.domain.model.statistics.WinningTotalStatistics
import lotto.ui.view.statistics.ShowStatisticsView

class ShowStatisticsController(
    private val showStatisticsView: ShowStatisticsView,
    private val winningTotalStatistics: WinningTotalStatistics
): Controller() {
    override fun run() {


    }

    private fun printStatistics() {
        showStatisticsView.printStatisticsTitleMessage()



        showStatisticsView.printTotalProfitRateMessage(winningTotalStatistics.totalProfitRate)
    }



}