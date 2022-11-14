package lotto.domain.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants.LOTTO_LENGTH
import lotto.utils.Constants.LOTTO_LENGTH_MUST_SIX_TEXT
import lotto.utils.Constants.LOTTO_NOT_DUPLICATE_TEXT
import lotto.utils.Constants.LOTTO_NUM_IN_RANGE_TEXT
import lotto.utils.Constants.MAX_LOTTO_NUM
import lotto.utils.Constants.MIN_LOTTO_NUM

class Lotto(private val numbers: List<Int>) {
    init {
        checkValidation()
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun contains(number: Int) = numbers.contains(number)

    private fun checkValidation() {
        require(numbers.size == LOTTO_LENGTH) {
            LOTTO_LENGTH_MUST_SIX_TEXT
        }
        require(numbers.distinct().size == LOTTO_LENGTH) {
            LOTTO_NOT_DUPLICATE_TEXT
        }
        numbers.forEach { number ->
            require(number in MIN_LOTTO_NUM..MAX_LOTTO_NUM) {
                LOTTO_NUM_IN_RANGE_TEXT
            }
        }
    }

    companion object {

        const val LOTTO_PRIZE = 1000
        fun newInstance(): Lotto {
            return Lotto(makeRandomNum())
        }

        private fun makeRandomNum(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }
}
