package lotto.domain.controller.ticket

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.common.*
import lotto.domain.controller.Controller
import lotto.domain.model.ticket.Lotto
import lotto.domain.model.ticket.LottoTicket
import lotto.domain.validator.InputValidator
import lotto.ui.view.ticket.BuyTicketView

class BuyTicketController(
    private val buyTicketView: BuyTicketView,
    private val lottoTicket: LottoTicket
) : Controller() {

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
        checkTicketMoney(inputTicketMoney)
    }

    private fun checkTicketMoney(inputTicketMoney: String) {
        val errorType = InputValidator.validateTicketMoney(inputTicketMoney)
        buyTicketView.printErrorMessage(errorType)

        updateTicketInfo(inputTicketMoney.toInt(), inputTicketMoney.toInt() / THOUSAND)
    }

    private fun updateTicketInfo(ticketMoney: Int, ticketCount: Int) {
        lottoTicket.apply {
            this.ticketMoney = ticketMoney
            this.ticketCount = ticketCount
        }
    }

    private fun makeLottoTicket() {
        val lottos = mutableListOf<Lotto>()

        repeat(lottoTicket.ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(
                START_LOTTO_NUMBER,
                END_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT
            ).sorted()

            val lotto = Lotto(numbers = numbers)
            lottos.add(lotto)
        }
        lottoTicket.lottos = lottos.toList()
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
}