package lotto

import lotto.domain.controller.ticket.BuyTicketController
import lotto.ui.view.ticket.BuyTicketView

fun main() {
    val buyTicketController = BuyTicketController(BuyTicketView())
    // buyTicketController.getTicketInfo()
    buyTicketController.printTicketCount()
    buyTicketController.printLottoNumber()
}
