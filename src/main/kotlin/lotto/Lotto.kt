package lotto

import lotto.constant.LOTTO_NUM_RANGE_END

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        lottoNumberDuplicationCheck()
    }

    private fun lottoNumberDuplicationCheck() {
        val used = BooleanArray(LOTTO_NUM_RANGE_END + 1)
        numbers.forEach {
            if (used[it]) throw IllegalArgumentException()
            used[it] = true
        }
    }
}