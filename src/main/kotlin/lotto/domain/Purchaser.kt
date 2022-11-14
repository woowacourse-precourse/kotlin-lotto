package lotto.domain

import lotto.resources.LOTTO_NUMBER_COUNT

object Purchaser {
    fun purchase(amount: Int) = Store.buyTickets(amount)

    fun calculateResult(winningLotto: WinningLotto, tickets: List<Lotto>): Pair<List<Int>, Int> {
        val resultRank = MutableList(LOTTO_NUMBER_COUNT) { 0 }
        var totalPrize = 0
        tickets.forEach {
            resultRank[winningLotto.getRank(it) - 1] += 1
            totalPrize += winningLotto.getPrize(it)
        }
        return Pair(resultRank, totalPrize)
    }

    fun calculateRateOfReturn(totalPrize: Int, amount: Int) = totalPrize * 10000 / (amount) / 100.0F
}
