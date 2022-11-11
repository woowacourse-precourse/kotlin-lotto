package lotto.domain

class LottoResult(
    val lottos: List<Lotto>,
    val winningNumber: WinningNumber,
    val origin: Int
) {
    private val _rankToCnt: MutableMap<LottoRank, Int>
    val rankToCnt: Map<LottoRank, Int>
        get() = _rankToCnt

    init {
        _rankToCnt = mutableMapOf(
            LottoRank.FIFTH to 0,
            LottoRank.FOURTH to 0,
            LottoRank.THIRD to 0,
            LottoRank.SECOND to 0,
            LottoRank.FIRST to 0,
        )

        countRank(lottos, winningNumber)
    }

    private fun countRank(lottos: List<Lotto>, winningNumber: WinningNumber) {
        for (lotto in lottos) {
            val rank = lotto.rank(winningNumber)
            _rankToCnt.merge(rank, 1, Integer::sum)
        }
    }

    fun computeProfit(): Double {
        var prizeSum = 0
        for ((rank, cnt) in rankToCnt) {
            prizeSum += rank.prize * cnt
        }
        return prizeSum / origin.toDouble() * 100.0
    }
}
