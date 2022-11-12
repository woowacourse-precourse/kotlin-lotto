package lotto.domain

class LottoResult(
    lottos: List<Lotto>,
    winningNumber: WinningNumber,
    originCost: Int
) {
    private val _rankToCnt: MutableMap<LottoRank, Int>
    val rankToCnt: Map<LottoRank, Int>
        get() = _rankToCnt

    val profit: Double

    init {
        _rankToCnt = mutableMapOf(
            LottoRank.FIFTH to 0,
            LottoRank.FOURTH to 0,
            LottoRank.THIRD to 0,
            LottoRank.SECOND to 0,
            LottoRank.FIRST to 0,
        )

        countRank(lottos, winningNumber)
        profit = computeProfit(originCost)
    }

    private fun countRank(lottos: List<Lotto>, winningNumber: WinningNumber) {
        val ranker = LottoRanker(lottos, winningNumber)
        val lottoToRank = ranker.rankAll()
        lottoToRank.values.forEach { _rankToCnt.merge(it, 1, Integer::sum) }
    }

    private fun computeProfit(originCost: Int): Double {
        var prizeSum = 0
        for ((rank, cnt) in rankToCnt) {
            prizeSum += rank.prize * cnt
        }
        return prizeSum / originCost.toDouble() * 100.0
    }
}
