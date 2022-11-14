package lotto

import data.*

class Winning {

    fun createRankList(matchCount: Int): List<Rank> {
        val lottoNumber = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val matchCountList = lottoNumber.createNumber()
        val rankList = matchCountList.map { matchCount ->
            when (matchCount) {
                NONE_MATCH, ONE_MATCH, TWO_MATCH -> Rank.LAST
                THREE_MATCH -> Rank.FIFTH
                FOUR_MATCH -> Rank.FOURTH
                FIVE_MATCH -> Rank.THIRD
                SIX_MATCH -> Rank.FIRST
                else -> Rank.SECOND
            }
        }
        return rankList
    }


    private fun createRankCountHashMap(rankList: List<Rank>): HashMap<Rank, Int> {
        val rankCountHashMap: HashMap<Rank, Int> = HashMap()

        rankCountHashMap[Rank.FIFTH] = rankList.count { it == Rank.FIFTH }
        rankCountHashMap[Rank.FOURTH] = rankList.count { it == Rank.FOURTH }
        rankCountHashMap[Rank.THIRD] = rankList.count { it == Rank.THIRD }
        rankCountHashMap[Rank.SECOND] = rankList.count { it == Rank.SECOND }
        rankCountHashMap[Rank.FIRST] = rankList.count { it == Rank.FIRST }

        return rankCountHashMap
    }

    private fun updateRank(): HashMap<Rank, Int> {
        val rankList = createRankList(0)
        val rankCountHashMap = createRankCountHashMap(rankList)
        println(StringResource.TOTAL.resource)
        println("3개 일치 (5,000원) - ${rankCountHashMap[Rank.FIFTH]}개")
        println("4개 일치 (50,000원) - ${rankCountHashMap[Rank.FOURTH]}개")
        println("5개 일치 (1,500,000원) - ${rankCountHashMap[Rank.THIRD]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${rankCountHashMap[Rank.SECOND]}개")
        println("6개 일치 (2,000,000,000원) - ${rankCountHashMap[Rank.FIRST]}개")

        return rankCountHashMap
    }

    private fun updateTotalReward(): Int {
        val rankCountHashMap = updateRank()
        val totalReward = rankCountHashMap.map { it
            when (it.key) {
                Rank.FIFTH -> Rank.FIFTH.reward * it.value
                Rank.FOURTH -> Rank.FOURTH.reward * it.value
                Rank.THIRD -> Rank.THIRD.reward * it.value
                Rank.SECOND -> Rank.SECOND.reward * it.value
                else -> Rank.FIRST.reward * it.value
            }
        }.sum()
        return totalReward
    }

    fun createYield(expense: Int) {
        val winning = Winning()
        val totalReward = winning.updateTotalReward()
        val purchase = (expense).toDouble()
        val rewardYield =  (totalReward / purchase) * PERCENTAGE
        println("총 수익률은 %.1f%%입니다.".format(rewardYield))
    }
}


