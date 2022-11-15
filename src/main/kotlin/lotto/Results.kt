package lotto

import lotto.Lotto.Companion.LOTTO_PRICE

class Results(
    private val numberOfLotto: Int
) {
    var rankResults: MutableMap<WinningRank, Int> = mutableMapOf()
    private var prizeMoney: Double
    lateinit var earningsRate: String

    init {
        for (rank in WinningRank.values()) {
            rankResults[rank] = 0
        }
        prizeMoney = 0.0
    }

    fun calculateResult(lottos: List<Lotto>, winningLotto: Lotto, bonusNumber: Int) {
        lottos.forEach { calculateLottoResult(it, winningLotto, bonusNumber) }
        earningsRate = String.format("%.1f", (prizeMoney / (numberOfLotto * LOTTO_PRICE)) * 100)
    }

    private fun calculateLottoResult(lotto: Lotto, winningLotto: Lotto, bonusNumber: Int) {
        val matchCount = lotto.getNumbers().count { winningLotto.getNumbers().contains(it) }
        val rank = when (matchCount) {
            6 -> WinningRank.FIRST
            5 -> {
                if (lotto.getNumbers().contains(bonusNumber)) {
                    WinningRank.SECOND
                } else {
                    WinningRank.THIRD
                }
            }
            4 -> WinningRank.FORTH
            3 -> WinningRank.FIFTH
            else -> WinningRank.NOTHING
        }
        prizeMoney += rank.prizeMoney
        rankResults[rank] = rankResults[rank]!!.plus(1)
    }
}