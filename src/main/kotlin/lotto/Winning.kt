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

    fun updateRank() {
        val rankList = createRankList(0)
        println("\n당첨 통계\n---")
        println("3개 일치 (5,000원) - ${updateFifthCount(rankList)}개")
        println("4개 일치 (50,000원) - ${updateFourthCount(rankList)}개")
        println("5개 일치 (1,500,000원) - ${updateThirdCount(rankList)}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${updateSecondCount(rankList)}개")
        println("6개 일치 (2,000,000,000원) - ${updateFirstCount(rankList)}개")
    }

    fun updateFifthCount(rankList: List<Rank>): Int {
        return rankList.count { rank -> rank == Rank.FIFTH }
    }

    fun updateFourthCount(rankList: List<Rank>): Int {
        return rankList.count { rank -> rank == Rank.FOURTH }
    }

    fun updateThirdCount(rankList: List<Rank>): Int {
        return rankList.count { rank -> rank == Rank.THIRD }
    }

    fun updateSecondCount(rankList: List<Rank>): Int {
        return rankList.count { rank -> rank == Rank.SECOND }
    }

    fun updateFirstCount(rankList: List<Rank>): Int {
        return rankList.count { rank -> rank == Rank.FIRST }
    }


}

const val NONE = 0
const val FIVE_THOUS = 5_000
const val FIFTY_THOUS = 50_000
const val ONE_MILLI_FIVE_HUND_THOUS = 1_500_000
const val THIRTY_MILLI = 30_000_000
const val TWO_BILLI = 2_000_000_000

