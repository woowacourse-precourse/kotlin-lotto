package lotto.domain

class LottoResult(lottos: List<Lotto>, winningNumber: WinningNumber) {
    private val rankToCnt = mutableMapOf<LottoRank, Int>()

    init {
        for (lotto in lottos) {
            val rank = lotto.getLottoRank(winningNumber)
            rankToCnt.merge(rank, 1, Integer::sum)
        }
    }

    fun computeProfit(origin: Int): Double {
        var prizeSum = 0
        for ((rank, cnt) in rankToCnt) {
            prizeSum += rank.prize * cnt
        }
        return prizeSum / origin.toDouble() * 100.0
    }

    override fun toString() =
        """
            ${LottoRank.FIFTH} - ${rankToCnt[LottoRank.FIFTH]}개
            ${LottoRank.FOURTH} - ${rankToCnt[LottoRank.FOURTH]}개
            ${LottoRank.THIRD} - ${rankToCnt[LottoRank.THIRD]}개
            ${LottoRank.SECOND} - ${rankToCnt[LottoRank.SECOND]}개
            ${LottoRank.FIRST} - ${rankToCnt[LottoRank.FIRST]}개
        """.trimIndent()
}