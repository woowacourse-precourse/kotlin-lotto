package lotto

import error.LottoError

class Lotto(private val numbers: List<Int>) {
    init {
        LottoError.checkLottoNumbers(numbers)
        // require(numbers.size == 6)
    }

    fun print() {
        println(numbers.toString())
    }
}
