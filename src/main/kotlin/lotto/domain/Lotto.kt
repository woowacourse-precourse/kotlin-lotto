package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        LottoValidator().validateLottoNumber(numbers)
    }

    fun getLottoResult(winningNumber: WinningNumber): LottoResult {
        val overlapNumber = getOverlapNumber(winningNumber.numbers)
        val bonusMatched = winningNumber.bonus in numbers
        return getLottoResult(overlapNumber, bonusMatched)
    }

    private fun getOverlapNumber(numbers: List<Int>) =
        this.numbers.count { it in numbers }

    private fun getLottoResult(matchedCnt: Int, bonusMatched: Boolean) = when (matchedCnt) {
        3 -> LottoResult.FIFTH
        4 -> LottoResult.FOURTH
        5 -> if (bonusMatched) LottoResult.SECOND else LottoResult.THIRD
        6 -> LottoResult.FIRST
        else -> LottoResult.FAIL
    }
}
