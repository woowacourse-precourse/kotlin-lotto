package domain

import lotto.LottoMessage

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.toSet().size == LOTTO_SIZE) { LottoMessage.LOTTERY_SIZE_ERROR }
        numbers.forEach { require(it in LOTTO_MIN_BOUND..LOTTO_MAX_BOUND) { LottoMessage.BONUS_RANGE_ERROR } }
    }

    fun countSameNumber(lotto: Lotto): Int {
        val differences = numbers.toMutableList()
        differences.removeAll(lotto.numbers)
        return 6 - differences.size
    }

    operator fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    companion object {
        private const val LOTTO_MIN_BOUND = 1
        private const val LOTTO_MAX_BOUND = 45
        private const val LOTTO_SIZE = 6
    }
}
