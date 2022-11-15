package lotto

import lotto.domain.calculator.LottoCalculator
import lotto.domain.controller.statistics.ShowStatisticsController
import lotto.domain.controller.ticket.BuyTicketController
import lotto.domain.controller.winning.MakeWinningNumberController
import lotto.domain.model.statistics.WinningTotalStatistics
import lotto.domain.model.ticket.LottoTicket
import lotto.domain.model.winning.WinningLotto
import lotto.ui.view.statistics.ShowStatisticsView
import lotto.ui.view.ticket.BuyTicketView
import lotto.ui.view.winning.MakeWinningNumberView

fun main() {
    val buyTicketView = BuyTicketView()
    val lottoTicket = LottoTicket.emptyLottoTicket() // 구매한 로또 티켓 데이터

    val buyTicketController =
        BuyTicketController(
            buyTicketView = buyTicketView,
            lottoTicket = lottoTicket
        )

    val makeWinningNumberView = MakeWinningNumberView()
    val winningLotto = WinningLotto.emptyWinningLotto() // 당첨 로또 번호 데이터

    val makeWinningNumberController =
        MakeWinningNumberController(
            makeWinningNumberView = makeWinningNumberView,
            winningLotto = winningLotto
        )

    buyTicketController.run()
    makeWinningNumberController.run()

    val showStatisticsView = ShowStatisticsView()
    val winningTotalStatistics =
        LottoCalculator.getWinningTotalStatistics(lottoTicket = lottoTicket, winningLotto = winningLotto)

    val showStatisticsController = ShowStatisticsController(
        showStatisticsView = showStatisticsView,
        winningTotalStatistics = winningTotalStatistics
    )

    showStatisticsController.run()
}
