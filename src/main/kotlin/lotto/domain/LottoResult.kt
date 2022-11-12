package lotto.domain

class LottoResult(
    lottos: List<Lotto>,
    winningNumber: WinningNumber,
    originCost: Int
) {

    val rankToCnt: Map<LottoRank, Int>
    val profit: Double

    init {
        rankToCnt = countRank(lottos, winningNumber)
        profit = computeProfit(originCost)
    }

    private fun countRank(lottos: List<Lotto>, winningNumber: WinningNumber): Map<LottoRank, Int> {
        val rankToCnt = LottoRank.values()
            .associateWith { 0 }
            .toMutableMap()

        LottoRanker(lottos, winningNumber)
            .rankAll()
            .values
            .forEach {
                rankToCnt.merge(it, 1, Integer::sum)
            }

        return rankToCnt
    }

    private fun computeProfit(originCost: Int): Double {
        var prizeSum = 0
        for ((rank, cnt) in rankToCnt) {
            prizeSum += rank.prize * cnt
        }
        return prizeSum / originCost.toDouble() * 100.0
    }
}
