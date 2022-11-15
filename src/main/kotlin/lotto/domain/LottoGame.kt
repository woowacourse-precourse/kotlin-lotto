package lotto.domain

import lotto.enum.Reward
import lotto.enum.WinningRank

class LottoGame(
    private val winningLotto: Lotto,
    private val bonusNumber: BonusNumber,
    private val userLotto: LottoList
) {
    fun play(): Pair<List<Int>, Double> {
        val winningResult = userLotto.compare(winningLotto, bonusNumber)
        val totalReward = calculateTotalReward(winningResult)
        val earningRate = calculateEarningRate(totalReward)
        val winningList = getWinningList(winningResult)
        return winningList to earningRate
    }

    private fun getWinningList(winningResult: Map<WinningRank, Int>): List<Int>{
        val result = mutableListOf<Int>()
        result.add(winningResult[WinningRank.FIFTH]?:0)
        result.add(winningResult[WinningRank.FOURTH]?:0)
        result.add(winningResult[WinningRank.THIRD]?:0)
        result.add(winningResult[WinningRank.SECOND]?:0)
        result.add(winningResult[WinningRank.FIRST]?:0)
        return result
    }
    private fun calculateEarningRate(totalReward: Int): Double {
        val purchaseAmount = userLotto.purchaseAmount().toDouble()
        return totalReward / purchaseAmount * 100
    }

    private fun calculateTotalReward(winningResult: Map<WinningRank, Int>): Int {
        return winningResult.map {
            Reward.valueOf(it.key.toString()).reward * it.value
        }.sum()
    }
}