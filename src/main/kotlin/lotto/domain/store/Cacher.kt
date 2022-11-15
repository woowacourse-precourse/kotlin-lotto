package lotto.domain.store

import lotto.domain.Lotto

private const val PURCHASE_STANDARD_UNIT = 1000

class Cacher {
    private val ticketingMachine = TicketingMachine()

    private var _numberOfLotteries: Int = 0
    val numberOfLotteries: Int get() = _numberOfLotteries

    fun returnCreatedLotteries(): List<Lotto> {
        return ticketingMachine.createLottoNumbers(_numberOfLotteries)
    }

    fun receiveMoney(money: Int) {
        _numberOfLotteries = calculateNumberOfLotteries(money)
    }

    private fun calculateNumberOfLotteries(money: Int): Int {
        return money / PURCHASE_STANDARD_UNIT
    }
}
