package lotto.domain

class LottoResult(
    val lottos: List<Lotto>,
    val winningNumber: WinningNumber,
    val origin: Int
) {
    private val _rankToCnt = mutableMapOf(
        LottoRank.FIFTH to 0,
        LottoRank.FOURTH to 0,
        LottoRank.THIRD to 0,
        LottoRank.SECOND to 0,
        LottoRank.FIRST to 0,
    )
    val rankToCnt: Map<LottoRank, Int>
        get() = _rankToCnt

    init {
        for (lotto in lottos) {
            val rank = lotto.getLottoRank(winningNumber)
            _rankToCnt.merge(rank, 1, Integer::sum)
        }
    }
}
