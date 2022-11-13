package lotto

import lotto.constant.LOTTO_BONUS_NUM_COUNT
import lotto.constant.LOTTO_NUM_COUNT
import lotto.constant.LOTTO_NUM_RANGE_END
import lotto.exception.DuplicateInputException
import lotto.util.ErrorType
import lotto.util.printErrorMessage
import lotto.util.showError

class WinLotto(val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUM_COUNT + LOTTO_BONUS_NUM_COUNT) {
            printErrorMessage(ErrorType.WRONG_WIN_LOTTO_NUMBERS_COUNT)
        }
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