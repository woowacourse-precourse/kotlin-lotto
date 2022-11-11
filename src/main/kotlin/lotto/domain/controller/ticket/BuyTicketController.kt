package lotto.domain.controller.ticket

import lotto.domain.model.ticket.LottoTicket
import lotto.ui.view.ticket.BuyTicketView

class BuyTicketController(
    private val lottoTicket: LottoTicket,
    private val buyTicketView: BuyTicketView
) {
    private var ticketMoney = ""

    fun getMoney() {
        ticketMoney = buyTicketView.enterTicketMoney()
    }

    fun printMoney() {
        buyTicketView.printBuyTicketMessage(money = ticketMoney)
    }
}