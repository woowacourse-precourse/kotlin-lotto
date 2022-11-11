package lotto.domain.controller.ticket

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.controller.Controller
import lotto.domain.model.ticket.Lotto
import lotto.domain.model.ticket.LottoTicket
import lotto.ui.view.ticket.BuyTicketView

class BuyTicketController(
    private val buyTicketView: BuyTicketView,
    private val lottoTicket: LottoTicket
): Controller() {
    private var _ticketMoney = lottoTicket.ticketMoney
    private var _ticketCount = lottoTicket.ticketCount
    private val _lottos = mutableListOf<Lotto>()

    override fun run() {
        // 티켓 금액을 입력받는다.
        enterTicketMoney()

        // 구매한 티켓 개수를 출력한다.
        updateLottoTicket()
        printTicketCount()

        // 티켓 개수만큼 로또 번호를 만든다.
        makeLottoTicket()

        // 티켓 정보를 업데이트한다.
        updateLottoTicket()

        // 티켓 정보를 출력한다.
        printLottoTicketNumber()
    }


    private fun enterTicketMoney() {
        _ticketMoney = buyTicketView.enterTicketMoney().toInt()
        _ticketCount = _ticketMoney / THOUSAND


        // TODO: 입력 금액 검증
    }

    // TODO: 한번에 업데이트할건지 따로 set할건지 고민
    private fun updateLottoTicket() {
        lottoTicket.apply {
            ticketMoney = _ticketMoney
            ticketCount = _ticketCount
            lottos = _lottos.toList()
        }
    }

    private fun printTicketCount() {
        buyTicketView.printTicketCountMessage(ticketCount = lottoTicket.ticketCount)
    }

    private fun printLottoTicketNumber() {
        lottoTicket.lottos.forEach { lotto ->
            val lottoNumbers = lotto.getLottoNumbers().joinToString(", ")
            buyTicketView.printLottoNumberMessage(lottoNumbers = lottoNumbers)
        }
    }

    private fun makeLottoTicket() {
        repeat(_ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(
                START_LOTTO_NUMBER,
                END_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT
            )
            val lotto = Lotto(numbers = numbers)
            _lottos.add(lotto)
        }
    }

    companion object {
        private const val THOUSAND = 1_000
        private const val START_LOTTO_NUMBER = 1
        private const val END_LOTTO_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
    }
}