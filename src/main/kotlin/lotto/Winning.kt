package lotto

enum class Rank(val reward: Int) {
    LAST(0),
    FIFTH(5000),
    FOURTH(50000)
}

class Winning {
    // Rank 반환,, 돈 추가
    fun updateRank(matchCount: Int): Any {
/*        val lottoNumber = Lotto(listOf(1,2,3,4,5,6))
        val matchCountList = lottoNumber.createNumber()*/
        val rankResult = when (matchCount) {
            0,1,2 -> Rank.LAST
            3 -> Rank.FIFTH
            4 -> Rank.FOURTH
            else -> matchCount
        }

        return rankResult

    }
}
