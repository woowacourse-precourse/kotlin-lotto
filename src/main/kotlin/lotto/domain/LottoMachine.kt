package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine (cost: Int) {
    private val ticketCount = cost % 1000

    init {
        require(cost >= 1000) { COST_RANGE_EXCEPTION }
        require(cost % 1000 == 0) { COST_UNIT_EXCEPTION }
    }

    fun generate(): List<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()
        var lottoTicket: Lotto

        repeat(ticketCount) {
            lottoTicket = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            lottoTickets.add(lottoTicket)
        }

        println(ticketCount.toString() + TICKET_BUY_MESSAGE)
        return lottoTickets
    }

    companion object {
        const val COST_RANGE_EXCEPTION = "구매 불가능한 금액입니다. 1000원 이상부터 구매 가능합니다."
        const val COST_UNIT_EXCEPTION = "구매 불가능한 금액입니다. 1000원 단위로 구매 가능합니다."
        const val TICKET_BUY_MESSAGE = "개를 구매했습니다."
    }
}