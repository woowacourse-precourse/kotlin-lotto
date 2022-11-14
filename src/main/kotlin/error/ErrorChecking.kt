package error

import resource.LOTTO_LENGTH
import resource.RANGE_END
import resource.RANGE_START

class ErrorChecking(
    private val numbers: List<Int>
) {
    fun checkLottoNumbers() {
        checkOutOfRange()
        checkDuplicate()
    }

    fun checkOutOfRange() {
        for(number in numbers) {
            if(number !in RANGE_START..RANGE_END) {
                ErrorMaking.makeError(ErrorMaking.OUT_OF_RANGE)
            }
        }
    }

    fun checkDuplicate() {
        val set = numbers.toSet()
        if(set.size != numbers.size) {
            ErrorMaking.makeError(ErrorMaking.NUMBER_DUPLICATED)
        }
    }
}