package lotto

enum class Rank(val reward: Int) {
    LAST(NONE),
    FIFTH(FIVE_THOUS),
    FOURTH(FIFTY_THOUS),
    THIRD(ONE_MILLI_FIVE_HUND_THOUS),
    SECOND(THIRTY_MILLI),
    FIRST(TWO_BILLI)
}

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

    fun updateRank(): HashMap<Rank, Int> {
        val rankList = createRankList(0)
        val rankCountHashMap = createRankCountHashMap(rankList)
        println("\n당첨 통계\n---")
        println("3개 일치 (5,000원) - ${rankCountHashMap[Rank.FIFTH]}개")
        println("4개 일치 (50,000원) - ${rankCountHashMap[Rank.FOURTH]}개")
        println("5개 일치 (1,500,000원) - ${rankCountHashMap[Rank.THIRD]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${rankCountHashMap[Rank.SECOND]}개")
        println("6개 일치 (2,000,000,000원) - ${rankCountHashMap[Rank.FIRST]}개")

        return rankCountHashMap
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

}

const val NONE = 0
const val FIVE_THOUS = 5_000
const val FIFTY_THOUS = 50_000
const val ONE_MILLI_FIVE_HUND_THOUS = 1_500_000
const val THIRTY_MILLI = 30_000_000
const val TWO_BILLI = 2_000_000_000

