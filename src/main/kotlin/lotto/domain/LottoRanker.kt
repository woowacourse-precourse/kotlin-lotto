package lotto.domain

class LottoRanker(lottos: List<Lotto>, winningNumber: WinningNumber) {
    val rankToCnt = mutableMapOf<LottoRank, Int>()

    init {
        for (lotto in lottos) {
            val rank = lotto.getLottoRank(winningNumber)
            rankToCnt.merge(rank, 1, Integer::sum)
        }
    }
}