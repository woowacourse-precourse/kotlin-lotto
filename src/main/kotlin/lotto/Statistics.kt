package lotto

import java.lang.StringBuilder

class Statistics {
    companion object {
        fun formatWinRanks(winRanks: Map<LottoRank, Int>): String {
            val formattedRank = StringBuilder()

            formattedRank.append("3개 일치 (5,000원) - ${winRanks[LottoRank.FIFTH] ?: 0}개\n")
            formattedRank.append("4개 일치 (50,000원) - ${winRanks[LottoRank.FOURTH] ?: 0}개\n")
            formattedRank.append("5개 일치 (1,500,000원) - ${winRanks[LottoRank.THIRD] ?: 0}개\n")
            formattedRank.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winRanks[LottoRank.SECOND] ?: 0}개\n")
            formattedRank.append("6개 일치 (2,000,000,000원) - ${winRanks[LottoRank.FIRST] ?: 0}개\n")

            return formattedRank.toString()
        }

        fun formatYield(yield: Float): String {
            return "총 수익률은 $`yield`%입니다."
        }
    }
}