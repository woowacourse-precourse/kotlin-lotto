package lotto.domain

class CalculateRanking() {

    fun calculateRanking(lotto:Lotto, winning: Lotto, bonus:Int): CONSTANT.RANKING {
        val lottoList = lotto.returnLottoNumbers()
        val winningList = winning.returnLottoNumbers()
        val sameNumberCount = countSameNumber(lottoList,winningList)
        when(sameNumberCount){
            CONSTANT.RANKING.FIRST.params -> return CONSTANT.RANKING.FIRST
            CONSTANT.RANKING.FOURTH.params -> return CONSTANT.RANKING.FOURTH
            CONSTANT.RANKING.FIFTH.params -> return CONSTANT.RANKING.FIFTH
        }
        if(sameNumberCount == CONSTANT.RANKING.SECOND.params && checkBonusInLotto(lottoList,bonus))
            return CONSTANT.RANKING.SECOND
        if(sameNumberCount == CONSTANT.RANKING.THIRD.params && !checkBonusInLotto(lottoList,bonus))
            return CONSTANT.RANKING.THIRD
        return CONSTANT.RANKING.NONE
    }

    fun countSameNumber(lotto: List<Int>, winning: List<Int>): Int {
        val diff = lotto.toSet().minus(winning.toSet())
        return winning.size - diff.size
    }

    fun checkBonusInLotto(lotto: List<Int>, bonus: Int): Boolean {
        return lotto.contains(bonus)
    }
}