package lotto.domain

import lotto.resources.ERROR_INPUT_VALUE_MULTIPLE_OF_1000_ONLY
import lotto.resources.LOTTO_TICKET_PRICE

class Store {
    fun buyTickets(amount: Int) = 0.until(getTicket(amount)).map { NumberGenerator().createRandomNumbers() }

    private fun getTicket(amount: Int): Int {
        require(amount % LOTTO_TICKET_PRICE == 0) { ERROR_INPUT_VALUE_MULTIPLE_OF_1000_ONLY }
        return amount / LOTTO_TICKET_PRICE
    }
}
