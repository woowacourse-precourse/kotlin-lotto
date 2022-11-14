package lotto

import error.LottoError
import resource.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun checkOutOfRange() {
        for(number in numbers) {
            if(number !in RANGE_START..RANGE_END) {
                LottoError.makeError(LottoError.OUT_OF_RANGE)
            }
        }
    }
}
