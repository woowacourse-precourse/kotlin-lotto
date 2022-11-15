package lotto.domain

import lotto.Lotto

class CountRankings {
    private val compare = Compare()
    private val ranking = Ranking()
    fun countRankings(winningNumbers: List<Int>, bonusNumber: Int, lottos: List<Lotto>): HashMap<Int, Int> {
        var rankingCounts = hashMapOf<Int, Int>()
        for (index in 0..5) {
            rankingCounts[index] = 0
        }
        for (index in lottos.indices) {
            val winCount = compare.checkWinningNumbers(winningNumbers, lottos[index].getNumbers())
            val isBonus = compare.checkBonusNumber(bonusNumber, lottos[index].getNumbers())
            val rank = ranking.checkRanking(winCount, isBonus)
            rankingCounts.replace(rank, rankingCounts[rank]!! + 1)
        }
        return rankingCounts
    }
}