package lotto

import lotto.domain.controller.ticket.BuyTicketController
import lotto.domain.controller.winning.MakeWinningNumberController
import lotto.domain.model.ticket.LottoTicket
import lotto.domain.model.winning.WinningLotto
import lotto.ui.view.ticket.BuyTicketView
import lotto.ui.view.winning.MakeWinningNumberView

fun main() {
    // TODO: 알아야하는 값 -> 티켓정보, 당첨번호 정보

    val buyTicketView = BuyTicketView()
    val lottoTicket = LottoTicket.emptyLottoTicket()
    val buyTicketController =
        BuyTicketController(
            buyTicketView = buyTicketView,
            lottoTicket = lottoTicket
        )

    val makeWinningNumberView = MakeWinningNumberView()
    val winningLotto = WinningLotto.emptyWinningLotto()
    val makeWinningNumberController =
        MakeWinningNumberController(
            makeWinningNumberView = makeWinningNumberView,
            winningLotto = winningLotto
        )

    buyTicketController.run()
    makeWinningNumberController.run()
}
