package lotto

enum class Rank(val reward: Int) {
    LAST(0)
}

class Winning {
    // Rank 반환,, 돈 추가
    fun updateRank(matchCount: Int): Rank {
/*        val lottoNumber = Lotto(listOf(1,2,3,4,5,6))
        val matchCountList = lottoNumber.createNumber()*/
        when (matchCount) {
            0,1,2 -> Rank.LAST
        }

        return Rank.LAST
    }
}
