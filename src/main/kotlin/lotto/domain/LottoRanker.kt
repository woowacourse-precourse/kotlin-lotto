package lotto.domain

class LottoRanker {
    fun rank(lotto: Lotto, winningNumber: WinningNumber): LottoRank {
        val matchedCnt = lotto.compare(winningNumber.winLotto)
        val bonusMatched = lotto.contains(winningNumber.bonus)
        return getLottoRank(matchedCnt, bonusMatched)
    }

    private fun getLottoRank(matchedCnt: Int, bonusMatched: Boolean) = LottoRank.values()
        .firstOrNull {
            (it.matchedCnt == matchedCnt) and (it.bonusMatched == bonusMatched)
        } ?: LottoRank.FAIL
}
