package lotto.domain

object Purchaser {
    fun purchase(amount: Int) = Store().buyTickets(amount).map { Lotto(it) }

    fun calculateResult(winningLotto: WinningLotto, tickets: List<Lotto>): Pair<MutableList<Int>, Int> {
        val resultRank = mutableListOf(0, 0, 0, 0, 0, 0)
        var totalPrize = 0
        tickets.forEach {
            resultRank[winningLotto.getRank(it.toList()) - 1] += 1
            totalPrize += winningLotto.getPrize(it.toList())
        }
        return Pair(resultRank, totalPrize)
    }

    fun calculateRateOfReturn(totalPrize: Int, amount: Int) = totalPrize * 10000 / (amount) / 100.0F
}
