package lotto.domain.controller.ticket

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.model.ticket.Lotto
import lotto.ui.view.ticket.BuyTicketView

class BuyTicketController(private val buyTicketView: BuyTicketView) {
    private var ticketMoney = ""
    private var ticketCount = 0
    private val _lottoTickets = mutableListOf<Lotto>()
    private val lottoTickets: MutableList<Lotto>
        get() = _lottoTickets

    init {
        initTicket()
    }

    fun run() {
        // 구매한 티켓 개수를 출력한다.
        printTicketCount()

        // 티켓 개수만큼 로또를 만든다.
        makeLottoTicket()

        // 티켓 정보를 출력한다.
        printLottoTicketNumber()
    }

    private fun initTicket() {
        ticketMoney = buyTicketView.enterTicketMoney()
        ticketCount = ticketMoney.toInt() / THOUSAND
    }

    private fun printTicketCount() {
        buyTicketView.printTicketCountMessage(ticketCount = ticketCount)
    }

    private fun printLottoTicketNumber() {
        repeat(ticketCount) { ticketIndex ->
            val lottoNumbers = _lottoTickets[ticketIndex].getLottoNumbers().joinToString(", ")
            buyTicketView.printLottoNumberMessage(lottoNumbers = lottoNumbers)
        }
    }

    private fun makeLottoTicket() {
        repeat(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(
                START_LOTTO_NUMBER,
                END_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT
            )
            val lotto = Lotto(numbers = numbers)
            _lottoTickets.add(lotto)
        }
    }

    companion object {
        private const val THOUSAND = 1_000
        private const val START_LOTTO_NUMBER = 1
        private const val END_LOTTO_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
    }
}