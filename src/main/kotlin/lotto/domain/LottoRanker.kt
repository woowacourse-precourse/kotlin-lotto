package lotto.domain

class LottoRanker(val lottos: List<Lotto>, val winningNumber: WinningNumber) {
    private fun rank(lotto: Lotto): LottoRank {
        val matchedCnt = lotto.compare(winningNumber.winLotto)
        val bonusMatched = lotto.contains(winningNumber.bonus)
        return LottoRank.valueOf(matchedCnt, bonusMatched)
    }

    fun rankAll(): Map<Lotto, LottoRank> {
        return lottos.associateWith { rank(it) }
    }
}
