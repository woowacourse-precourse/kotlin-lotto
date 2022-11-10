package lotto.domain

import kotlin.math.round

class LottoResult(lottos: List<Lotto>, winningNumber: WinningNumber) {
    private val rankToCnt = mutableMapOf(
        LottoRank.FIFTH to 0,
        LottoRank.FOURTH to 0,
        LottoRank.THIRD to 0,
        LottoRank.SECOND to 0,
        LottoRank.FIRST to 0,
    )

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
        val profit = prizeSum / origin.toDouble() * 100.0
        return round(profit * 10) / 10.0
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
