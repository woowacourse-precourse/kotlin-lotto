package lotto

import lotto.domain.controller.ticket.BuyTicketController
import lotto.ui.view.ticket.BuyTicketView

fun main() {
    val buyTicketView = BuyTicketView()
    val buyTicketController = BuyTicketController(buyTicketView = buyTicketView)

    buyTicketController.run()
}
