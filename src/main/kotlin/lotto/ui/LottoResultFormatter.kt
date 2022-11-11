package lotto.ui

import lotto.domain.LottoRank
import lotto.domain.LottoResult
import lotto.util.toPriceFormatted

class LottoResultFormatter(private val lottoResult: LottoResult) {
    fun getStatInfo(): String {
        val rankToCnt = lottoResult.rankToCnt
        val stats = mutableListOf<String>()
        for (rank in LottoRank.values()) {
            if (rank == LottoRank.FAIL) {
                continue
            }
            val rankInfo = getRankInfo(rank)
            val rankCnt = rankToCnt[rank]!!
            stats.add(
                STAT_INFO_FORMAT.format(rankInfo, rankCnt)
            )
        }
        return stats.joinToString("\n")
    }

    fun getProfitInfo(): String {
        val profit = lottoResult.profit
        return PROFIT_INFO_FORMAT.format(profit)
    }

    fun getRankInfo(lottoRank: LottoRank): String {
        val prize = lottoRank.prize
        val matchCnt = lottoRank.matchedCnt
        val prizeFormatted = prize.toPriceFormatted()
        val infoFormat = if (lottoRank == LottoRank.SECOND) {
            SECOND_RANK_INFO_FORMAT
        } else {
            RANK_INFO_FORMAT
        }
        return infoFormat.format(matchCnt, prizeFormatted)
    }

    companion object {
        private const val PROFIT_INFO_FORMAT = "%.1f%%"
        private const val STAT_INFO_FORMAT = "%s - %d개"
        private const val RANK_INFO_FORMAT = "%d개 일치 (%s원)"
        private const val SECOND_RANK_INFO_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원)"
    }
}
