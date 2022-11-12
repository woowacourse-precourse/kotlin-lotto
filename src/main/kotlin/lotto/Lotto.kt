package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun calculateWinRank(winNumbers: List<Int>, bonus: Int): LottoRank {
        val commonNumbers = numbers.intersect(winNumbers.toSet())
        val isBonusOn = numbers.contains(bonus)
        val rank = when (commonNumbers.size) {
            3 -> LottoRank.FIFTH
            4 -> LottoRank.FOURTH
            5 -> if (isBonusOn) LottoRank.SECOND else LottoRank.THIRD
            6 -> LottoRank.FIRST
            else -> LottoRank.FAIL
        }
        return rank
    }

    // TODO: 추가 기능 구현
}
