package lotto

import error.LottoError

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)

        LottoError.checkLottoNumbers(numbers)
    }

    fun print() {
        println(numbers.toString())
    }
}
