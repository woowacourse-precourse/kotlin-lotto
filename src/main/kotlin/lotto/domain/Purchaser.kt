package lotto.domain

import lotto.resources.ERROR_INPUT_VALUE_NUMBER_ONLY

class Purchaser(amount: Int?) {
    var amount = 0
        private set
    var tickets: List<Lotto> = emptyList()

    init {
        requireNotNull(amount) { ERROR_INPUT_VALUE_NUMBER_ONLY }
        this.amount = amount
    }

    fun calculateResult(winningLotto: WinningLotto): Pair<MutableList<Int>, Int> {
        val resultRank = mutableListOf(0, 0, 0, 0, 0, 0)
        var totalPrize = 0
        tickets.map {
            resultRank[winningLotto.getRank(it.toList()) - 1] += 1
            totalPrize += winningLotto.getPrize(it.toList())
        }
        return Pair(resultRank, totalPrize)
    }

    fun calculateRateOfReturn(totalPrize: Int) = totalPrize * 10000 / (amount) / 100.0F
}
