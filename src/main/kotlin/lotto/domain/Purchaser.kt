package lotto.domain

class Purchaser() {
    fun calculateResult(winningLotto: WinningLotto, tickets: List<Lotto>): Pair<MutableList<Int>, Int> {
        val resultRank = mutableListOf(0, 0, 0, 0, 0, 0)
        var totalPrize = 0
        tickets.map {
            resultRank[winningLotto.getRank(it.toList()) - 1] += 1
            totalPrize += winningLotto.getPrize(it.toList())
        }
        return Pair(resultRank, totalPrize)
    }

    fun calculateRateOfReturn(totalPrize: Int, amount: Int) = totalPrize * 10000 / (amount) / 100.0F
}
