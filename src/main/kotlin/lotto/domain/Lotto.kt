package lotto.domain

import java.util.Collections.sort

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBERS_SIZE)
        require(numbers.all { it in LOTTO_NUMBER_RANGE_START..LOTTO_NUMBER_RANGE_END })
        require(numbers.toSet().size == numbers.size)
        sort(numbers)
    }

    fun numbers() = numbers

}
