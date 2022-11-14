package lotto.domain

import lotto.resources.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { ERROR_INPUT_VALUE_SIX_ONLY }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { ERROR_INPUT_VALUE_NO_DUPLICATES }
        require(numbers.firstOrNull { it !in LOTTO_START_NUMBER..LOTTO_END_NUMBER } == null) {
            ERROR_INPUT_VALUE_ONE_OR_FORTY_FIVE_ONLY
        }
    }

    fun toList(): List<Int> = numbers
}
