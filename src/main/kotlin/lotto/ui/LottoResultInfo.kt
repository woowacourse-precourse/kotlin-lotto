package lotto.ui

import lotto.domain.LottoRank
import lotto.domain.LottoResult
import lotto.util.toPriceFormatted

class LottoResultInfo(private val lottoResult: LottoResult) {
    fun getStatInfo(): String {
        val rankToCnt = lottoResult.rankToCnt
        val stats = mutableListOf<String>()
        for (rank in LottoRank.values()) {
            if (rank == LottoRank.FAIL) {
                continue
            }
            stats.add(
                "${getRankInfo(rank)} - ${rankToCnt[rank]}개"
            )
        }
        return stats.joinToString("\n")
    }

    fun getProfitInfo(): String {
        val profit = lottoResult.computeProfit()
        return String.format("%.1f", profit)
    }

    fun getRankInfo(lottoRank: LottoRank): String {
        val prize = lottoRank.prize
        val matchCnt = lottoRank.matchCnt
        val formatted = prize.toPriceFormatted()
        if (lottoRank == LottoRank.SECOND) {
            return "${matchCnt}개 일치, 보너스 볼 일치 (${formatted}원)"
        }
        return "${matchCnt}개 일치 (${formatted}원)"
    }
}
