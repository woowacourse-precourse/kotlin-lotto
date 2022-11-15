package lotto.domain

import lotto.enum.Configuration
import lotto.enum.WinningRank

class LottoList(private val lottoList: List<Lotto>) {
    override fun toString(): String {
        val result = StringBuilder("")
        lottoList.forEach {
            result.append("${it}\n")
        }
        return result.toString()
    }

    fun compare(winningLotto: Lotto, bonusNumber: BonusNumber): Map<WinningRank, Int> {
        val result = hashMapOf<WinningRank, Int>()
        lottoList.forEach {
            val (matches, bonusMatch)  = it.compare(winningLotto, bonusNumber)
            val winningRank = getWinningRank(matches, bonusMatch)?: WinningRank.NOTHING
            result[winningRank] = result[winningRank]?.plus(1)?:1
        }
        return result
    }

    private fun getWinningRank(matches: Int, bonusMatch: Boolean): WinningRank? {
        return WinningRank.values().firstOrNull {
            it.isWinning(matches, bonusMatch)
        }
    }

    fun purchaseAmount() = lottoList.size * Configuration.LOTTO_PRICE.number
}