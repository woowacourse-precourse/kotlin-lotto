package lotto.domain

import lotto.enum.Reward
import lotto.enum.WinningRank

class LottoGame(
    private val winningLotto: Lotto,
    private val bonusNumber: BonusNumber,
    private val userLotto: LottoList
) {
    private fun calculateTotalReward(winningResult: Map<WinningRank, Int>): Int {
        return winningResult.map {
            Reward.valueOf(it.key.toString()).reward * it.value
        }.sum()
    }
}