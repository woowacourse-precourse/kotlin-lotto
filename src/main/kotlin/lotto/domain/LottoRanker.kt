package lotto.domain

class LottoRanker(val lottos: List<Lotto>, val winningNumber: WinningNumber) {
    fun rank(lotto: Lotto): LottoRank {
        val matchedCnt = lotto.compare(winningNumber.winLotto)
        val bonusMatched = lotto.contains(winningNumber.bonus)
        return getLottoRank(matchedCnt, bonusMatched)
    }

    fun rankAll(): Map<Lotto, LottoRank> {
        val lottoToRank = mutableMapOf<Lotto, LottoRank>()
        for (lotto in lottos) {
            lottoToRank[lotto] = rank(lotto)
        }
        return lottoToRank
    }

    private fun getLottoRank(matchedCnt: Int, bonusMatched: Boolean) = LottoRank.values()
        .firstOrNull {
            (it.matchedCnt == matchedCnt) and (it.bonusMatched == bonusMatched)
        } ?: LottoRank.FAIL
}
