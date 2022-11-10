package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        Validator().validateLottoNumber(numbers)
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

    fun getLottoResult(winningNumbers: WinningNumbers): LottoResult {
        val overlapNumber = getOverlapNumber(winningNumbers.numbers)
        val bonusMatched = winningNumbers.bonus in numbers
        return getLottoResult(overlapNumber, bonusMatched)
    }

    // TODO: companion object == field ??
    companion object {
        fun generate() = Lotto(
            Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_LENGTH)
        )
    }
}
