package lotto

import lotto.data.ErrorMessage.ERROR_NUM_DUPLICATION
import lotto.data.ErrorMessage.ERROR_NUM_NOT_IN_RANGE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.toSet().size) { ERROR_NUM_DUPLICATION }
        for (index in numbers.indices)
            require(numbers[index] in 1..45) { ERROR_NUM_NOT_IN_RANGE }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
