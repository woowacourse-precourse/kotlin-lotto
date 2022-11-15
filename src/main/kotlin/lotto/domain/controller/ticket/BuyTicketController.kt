package lotto.domain.controller.ticket

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.common.END_LOTTO_NUMBER
import lotto.domain.common.LOTTO_NUMBER_COUNT
import lotto.domain.common.START_LOTTO_NUMBER
import lotto.domain.common.THOUSAND
import lotto.domain.controller.Controller
import lotto.domain.model.ticket.Lotto
import lotto.domain.model.ticket.LottoTicket
import lotto.domain.validator.InputValidator
import lotto.ui.view.ticket.BuyTicketView

class BuyTicketController(
    private val buyTicketView: BuyTicketView,
    private val lottoTicket: LottoTicket
): Controller() {
    private val _lottos = mutableListOf<Lotto>()

    override fun run() {
        // 티켓 금액을 입력받는다.
        enterTicketMoney()

        // 구매한 티켓 개수를 출력한다.
        printTicketCount()

        // 티켓 개수만큼 로또 번호를 만든다.
        makeLottoTicket()

        // 티켓 정보를 출력한다.
        printLottoTicketNumber()
    }


    private fun enterTicketMoney() {
        val inputTicketMoney = buyTicketView.enterTicketMoney()

        if (InputValidator.validateTicketMoney(inputTicketMoney)) {
            lottoTicket.ticketMoney = inputTicketMoney.toInt()
            lottoTicket.ticketCount = lottoTicket.ticketMoney / THOUSAND
        }
        else {
            buyTicketView.printErrorMessage()
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
        repeat(lottoTicket.ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(
                START_LOTTO_NUMBER,
                END_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT
            ).sorted()

            val lotto = Lotto(numbers = numbers)
            _lottos.add(lotto)
        }
        lottoTicket.lottos = _lottos.toList()
    }
}