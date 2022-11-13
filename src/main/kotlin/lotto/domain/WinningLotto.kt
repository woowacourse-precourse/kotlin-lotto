package lotto.domain

import lotto.utils.*
import lotto.utils.LottoExceptionHandler.validateLottoNumberDuplication
import lotto.utils.LottoExceptionHandler.validateLottoSize

class WinningLotto(private val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {

    init {
        validateLottoSize(this)
        validateLottoNumberDuplication(this)
    }

    fun compareLottoRank(lotto: Lotto, bonusNumber: LottoNumber): LottoRank {
        val matchedNumberCount = lotto.fold(INITIAL_COUNT) { matchedCount, lottoNumber ->
            matchedCount + checkMatch(lottoNumber)
        }

        return when (matchedNumberCount) {
            MATCH_SIX -> LottoRank.FIRST
            MATCH_FIVE -> getRankWhichBonus(bonusNumber)
            MATCH_FOUR -> LottoRank.FOURTH
            MATCH_THREE -> LottoRank.FIFTH
            else -> LottoRank.NO_LUCK
        }
    }

    private fun getRankWhichBonus(bonusNumber: LottoNumber): LottoRank {
        if (numbers.contains(bonusNumber)) {
            return LottoRank.SECOND
        }
        return LottoRank.THIRD
    }

    private fun checkMatch(lottoNumber: LottoNumber): Int {
        if (numbers.contains(lottoNumber)) {
            return 1
        }
        return 0
    }

    override fun toString(): String = numbers.joinToString(", ", "[", "]")

}