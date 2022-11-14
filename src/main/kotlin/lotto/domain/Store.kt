package lotto.domain

import lotto.resources.ERROR_INPUT_VALUE_MULTIPLE_OF_THOUSAND_ONLY
import lotto.resources.ERROR_INPUT_VALUE_POSITIVE_NUMBER_ONLY
import lotto.resources.LOTTO_TICKET_PRICE

object Store {
    fun buyTickets(amount: Int) = List(getTicket(amount)) { Lotto(NumberGenerator.createRandomNumbers()) }

    private fun getTicket(amount: Int): Int {
        require(amount % LOTTO_TICKET_PRICE == 0) { ERROR_INPUT_VALUE_MULTIPLE_OF_THOUSAND_ONLY }
        require(amount > 0) { ERROR_INPUT_VALUE_POSITIVE_NUMBER_ONLY }
        return amount / LOTTO_TICKET_PRICE
    }
}
