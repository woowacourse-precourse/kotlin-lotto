package lotto.domain

import lotto.utils.Constants.LOTTO_NUMBER_COUNT

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT)
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT)
    }

    fun value(): List<Int> {
        return numbers
    }
}
