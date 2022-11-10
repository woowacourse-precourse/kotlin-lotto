package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        LottoValidator().validateLottoNumber(numbers)
    }

    fun getLottoResult(winningNumber: WinningNumber): LottoRank {
        val overlapNumber = getOverlapNumber(winningNumber.numbers)
        val bonusMatched = winningNumber.bonus in numbers
        return getLottoResult(overlapNumber, bonusMatched)
    }

    private fun getOverlapNumber(numbers: List<Int>) =
        this.numbers.count { it in numbers }

    private fun getLottoResult(matchedCnt: Int, bonusMatched: Boolean) = when (matchedCnt) {
        3 -> LottoRank.FIFTH
        4 -> LottoRank.FOURTH
        5 -> if (bonusMatched) LottoRank.SECOND else LottoRank.THIRD
        6 -> LottoRank.FIRST
        else -> LottoRank.FAIL
    }
}
