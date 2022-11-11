package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        LottoValidator().validateLottoNumber(numbers)
    }

    fun rank(winningNumber: WinningNumber): LottoRank {
        val overlapNumber = getOverlapNumber(winningNumber.numbers)
        val bonusMatched = winningNumber.bonus in numbers
        return getLottoRank(overlapNumber, bonusMatched)
    }

    private fun getOverlapNumber(numbers: List<Int>) =
        this.numbers.count { it in numbers }

    private fun getLottoRank(matchedCnt: Int, bonusMatched: Boolean) = LottoRank.values()
        .firstOrNull {
            (it.matchCnt == matchedCnt) and (it.bonusMatched == bonusMatched)
        } ?: LottoRank.FAIL

    override fun toString(): String {
        return numbers.toString()
    }
}
