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
    // Rank 반환,, 돈 추가
    fun updateRank(matchCount: Int): Any {
/*        val lottoNumber = Lotto(listOf(1,2,3,4,5,6))
        val matchCountList = lottoNumber.createNumber()*/
        val rankResult = when (matchCount) {
            NONE_MATCH, ONE_MATCH, TWO_MATCH -> Rank.LAST
            THREE_MATCH -> Rank.FIFTH
            FOUR_MATCH -> Rank.FOURTH
            FIVE_MATCH -> Rank.THIRD
            SIX_MATCH -> Rank.FIRST
            else -> Rank.SECOND
        }

        return rankResult

    }
}

const val NONE = 0
const val FIVE_THOUS = 5_000
const val FIFTY_THOUS = 50_000
const val ONE_MILLI_FIVE_HUND_THOUS = 1_500_000
const val THIRTY_MILLI = 30_000_000
const val TWO_BILLI = 2_000_000_000

