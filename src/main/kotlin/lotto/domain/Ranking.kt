package lotto.domain

import lotto.data.Count
import lotto.data.Ranks

class Ranking {
    fun checkRanking(winning: Int, bonus: Boolean): Int {
        when (winning) {
            Count.SIX.num -> return Ranks.FIRST.rank
            Count.FIVE.num -> return if (bonus) Ranks.SECOND.rank else Ranks.THIRD.rank
            Count.FOUR.num -> return Ranks.FOURTH.rank
            Count.THREE.num -> return Ranks.FIFTH.rank
        }
        return 0
    }
}