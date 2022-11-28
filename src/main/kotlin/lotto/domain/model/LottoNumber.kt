package lotto.domain.model

import lotto.utils.Constants.LOTTO_NUM_IN_RANGE_TEXT
import lotto.utils.Constants.MAX_LOTTO_NUM
import lotto.utils.Constants.MIN_LOTTO_NUM

class LottoNumber(private val number: Int) {

    init {
        validationNumber(number)
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        private val CACHED_LOTTO_NUMBER = List(MAX_LOTTO_NUM) { idx ->
            LottoNumber(idx + 1)
        }

        fun valueOf(number: Int): LottoNumber {
            return CACHED_LOTTO_NUMBER[number - 1]
        }

        private fun validationNumber(number: Int) {
            require(number in MIN_LOTTO_NUM..MAX_LOTTO_NUM) {
                LOTTO_NUM_IN_RANGE_TEXT
            }
        }
    }
}