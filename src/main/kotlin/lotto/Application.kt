package lotto

import lotto.domain.controller.ticket.BuyTicketController
import lotto.domain.controller.winning.MakeWinningNumberController
import lotto.ui.view.ticket.BuyTicketView
import lotto.ui.view.winning.MakeWinningNumberView

fun main() {
    // TODO: 알아야하는 값 -> 티켓정보, 당첨번호 정보

    val buyTicketView = BuyTicketView()
    val buyTicketController = BuyTicketController(buyTicketView = buyTicketView)

    val makeWinningNumberView = MakeWinningNumberView()
    val makeWinningNumberController = MakeWinningNumberController(makeWinningNumberView = makeWinningNumberView)

    buyTicketController.run()
    makeWinningNumberController.run()
}
