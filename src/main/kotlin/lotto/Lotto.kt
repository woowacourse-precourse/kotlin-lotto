package lotto

import lotto.constant.LOTTO_NUM_COUNT
import lotto.constant.LOTTO_NUM_RANGE_END
import lotto.exception.DuplicateInputException
import lotto.util.showError

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUM_COUNT)
        lottoNumberDuplicationCheck()
    }

    private fun lottoNumberDuplicationCheck() {
        val used = BooleanArray(LOTTO_NUM_RANGE_END + 1)
        numbers.forEach {
            if (used[it]) {
                showError(DuplicateInputException())
                throw IllegalArgumentException()
            }
            used[it] = true
        }
    }
}