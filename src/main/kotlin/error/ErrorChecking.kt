package error

import resource.RANGE_END
import resource.RANGE_START

class ErrorChecking(
    private val numbers: List<Int>
) {
    fun checkLottoNumbers() {
        checkOutOfRange()
    }

    fun checkOutOfRange() {
        for(number in numbers) {
            if(number !in RANGE_START..RANGE_END) {
                ErrorMaking.makeError(ErrorMaking.OUT_OF_RANGE)
            }
        }
    }
}