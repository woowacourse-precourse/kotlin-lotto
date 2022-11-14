package error

import error.ErrorMaking.Companion.makeError
import resource.*

object LottoError {

    fun checkLottoNumbers(numbers: List<Int>) {
        checkOutOfRange(numbers)
        checkDuplicate(numbers)
        checkNumOfLotto(numbers)
    }

    fun checkNumOfLotto(numbers: List<Int>) {
        if(numbers.size != LOTTO_LENGTH) {
            makeError(ErrorMaking.INCORRECT_NUMBER)
        }
    }

    fun checkOutOfRange(numbers: List<Int>) {
        for(number in numbers) {
            if(number !in RANGE_START..RANGE_END) {
                makeError(ErrorMaking.OUT_OF_RANGE)
            }
        }
    }

    fun checkDuplicate(numbers: List<Int>) {
        val set = numbers.toSet()
        if(set.size != numbers.size) {
            makeError(ErrorMaking.NUMBER_DUPLICATED)
        }
    }
}