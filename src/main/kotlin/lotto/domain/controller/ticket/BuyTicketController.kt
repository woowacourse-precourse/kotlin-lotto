package lotto.domain.controller.ticket

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.model.ticket.Lotto
import lotto.ui.view.ticket.BuyTicketView

class BuyTicketController(
    private val buyTicketView: BuyTicketView
) {
    private var ticketMoney = ""
    private var ticketCount = 0

    private val lottoTickets = mutableListOf<Lotto>()

    init {
        initTicketInfo()
    }

    private fun initTicketInfo() {
        ticketMoney = buyTicketView.enterTicketMoney()
        ticketCount = ticketMoney.toInt() / THOUSAND
    }

    fun printTicketCount() {
        buyTicketView.printTicketCountMessage(ticketCount = ticketCount)
    }

    fun printLottoNumber() {
        buyTicketView.printLottoNumberMessage(lottoNumbers = )
    }

    private fun makeLottoTicket() {
        repeat(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(
                START_LOTTO_NUMBER,
                END_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT
            )
            val lotto = Lotto(numbers = numbers)
            lottoTickets.add(lotto)
        }
    }

    companion object {
        private const val THOUSAND = 1_000
        private const val START_LOTTO_NUMBER = 1
        private const val END_LOTTO_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
    }
}