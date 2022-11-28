package lotto.domain.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.LOTTO_LENGTH
import lotto.utils.Constants.LOTTO_LENGTH_MUST_SIX_TEXT
import lotto.utils.Constants.LOTTO_NOT_DUPLICATE_TEXT
import lotto.utils.Constants.LOTTO_NUM_IN_RANGE_TEXT
import lotto.utils.Constants.MAX_LOTTO_NUM
import lotto.utils.Constants.MIN_LOTTO_NUM

class Lotto(private val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {
    init {
        checkValidation()
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun contains(number: Int) = numbers.contains(LottoNumber.valueOf(number))

    private fun checkValidation() {
        require(numbers.size == LOTTO_LENGTH) {
            LOTTO_LENGTH_MUST_SIX_TEXT
        }
        require(numbers.distinct().size == LOTTO_LENGTH) {
            LOTTO_NOT_DUPLICATE_TEXT
        }
    }

    companion object {
        const val LOTTO_PRIZE = 1_000
    }
}
