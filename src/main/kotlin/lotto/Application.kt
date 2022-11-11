package lotto

import lotto.domain.controller.ticket.BuyTicketController
import lotto.domain.controller.winning.MakeWinningNumberController
import lotto.ui.view.ticket.BuyTicketView
import lotto.ui.view.winning.MakeWinningNumberView

fun main() {
    val buyTicketView = BuyTicketView()
    val buyTicketController = BuyTicketController(buyTicketView = buyTicketView)

    val makeWinningNumberView = MakeWinningNumberView()
    val makeWinningNumberController = MakeWinningNumberController(makeWinningNumberView = makeWinningNumberView)

    buyTicketController.run()
    makeWinningNumberController.run()
}
