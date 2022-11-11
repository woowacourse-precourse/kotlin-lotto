package lotto.domain

import lotto.Exceptions
import camp.nextstep.edu.missionutils.Randoms

const val TICKET_BUY_MESSAGE = "개를 구매했습니다."

class LottoGenerator(cost: Int) {
    private val inputCost = cost

    init{
        Exceptions().validateCost(inputCost)
    }

    fun generate() : List<Lotto> {
        val ticketCount = inputCost % 100
        val lottoTickets = mutableListOf<Lotto>()
        var lottoTicket: Lotto

        repeat(ticketCount) {
            lottoTicket = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            lottoTickets.add(lottoTicket)
        }

        println(inputCost.toString() + TICKET_BUY_MESSAGE)
        return lottoTickets
    }
}