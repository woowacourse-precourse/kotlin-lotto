package lotto.domain

import util.Exceptions
import util.Messages

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            throw IllegalArgumentException(Messages.ERROR_MESSAGE + Messages.ERROR_LOTTO_SIZE)
        }
        // 로또번호 중복 예외 확인
        Exceptions.hasDuplicateNumbers(numbers)
    }

    // 로또번호를 오름차순 정렬
    fun getOrderedNumbers(): List<Int> {
        return numbers.sorted()
    }
}
