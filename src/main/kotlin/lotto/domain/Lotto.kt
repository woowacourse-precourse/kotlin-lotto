package lotto.domain

import lotto.domain.NumberGenerator.Companion.LOTTO_END_NUMBER
import lotto.domain.NumberGenerator.Companion.LOTTO_NUMBER_COUNT
import lotto.domain.NumberGenerator.Companion.LOTTO_START_NUMBER

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "[ERROR] 입력은 6개만 있어야합니다." }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { "[ERROR] 중복된 숫자가 있으면 안됩니다." }
        require(
            numbers.filter { it in LOTTO_START_NUMBER..LOTTO_END_NUMBER }.size == LOTTO_NUMBER_COUNT
        ) { "[ERROR] 로또 번호는 1부터 45까지 사이의 숫자여야 합니다." }
    }

    fun toList(): List<Int> = numbers
}
