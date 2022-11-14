package lotto

import error.ErrorChecking

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)

        ErrorChecking(numbers).checkLottoNumbers()
    }
}
