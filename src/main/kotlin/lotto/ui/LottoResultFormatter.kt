package lotto.ui

import lotto.domain.LottoRank
import lotto.domain.LottoResult
import java.text.DecimalFormat

class LottoResultFormatter(private val lottoResult: LottoResult) {
    fun getStatInfo(): String {
        val rankCounts = lottoResult.rankToCnt
        return LottoRank.values()
            .filter { it != LottoRank.FAIL }
            .joinToString("\n") {
                STAT_INFO_FORMAT.format(getRankInfo(it), rankCounts[it] ?: 0)
            }
    }

    fun getProfitInfo(): String {
        val profit = lottoResult.profit
        return PROFIT_INFO_FORMAT.format(profit)
    }

    fun getRankInfo(lottoRank: LottoRank): String {
        val matchedCnt = lottoRank.matchedCnt
        val prizeFormatted = prizeFormat(lottoRank.prize)
        val infoFormat = if (lottoRank == LottoRank.SECOND) {
            SECOND_RANK_INFO_FORMAT
        } else {
            RANK_INFO_FORMAT
        }
        return infoFormat.format(matchedCnt, prizeFormatted)
    }

    private fun prizeFormat(prize: Int) = DecimalFormat("#,###")
        .format(prize)

    companion object {
        private const val PROFIT_INFO_FORMAT = "%.1f%%"
        private const val STAT_INFO_FORMAT = "%s - %d개"
        private const val RANK_INFO_FORMAT = "%d개 일치 (%s원)"
        private const val SECOND_RANK_INFO_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원)"
    }
}
