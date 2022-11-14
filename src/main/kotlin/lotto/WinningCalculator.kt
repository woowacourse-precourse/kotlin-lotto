package lotto

import Util.Constants
import Util.Ranking

class WinningCalculator() {

    private val winningList =
        mutableListOf<Int>(
            Constants.ZERO.constant,
            Constants.ZERO.constant,
            Constants.ZERO.constant,
            Constants.ZERO.constant,
            Constants.ZERO.constant,
            Constants.ZERO.constant
        )

    fun getResult(lottoNumbers: List<List<Int>>, winningNumber: List<Int>, bonusNumber: Int): MutableList<Int> {
        for (i in lottoNumbers.indices) {
            val lotto = Lotto(lottoNumbers[i])
            val winningResult = lotto.compareWinningNumber(winningNumber)
            val bonusResult = lotto.compareBonusNumber(bonusNumber)

            getWinningList(winningResult, bonusResult)
        }
        return winningList
    }

    private fun getWinningList(winningResult: Int, bonusResult: Boolean) {
        when (winningResult) {
            Ranking.FIFTH.match -> winningList[Ranking.FIFTH.ranking]++
            Ranking.FOURTH.match -> winningList[Ranking.FOURTH.ranking]++
            Ranking.THIRD.match -> if (bonusResult) winningList[Ranking.SECOND.ranking]++ else winningList[Ranking.THIRD.ranking]++
            Ranking.FIRST.match -> winningList[Ranking.FIRST.ranking]++
            else -> winningList[Constants.ZERO.constant]++
        }
    }
}