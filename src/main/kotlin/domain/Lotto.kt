package domain

import utils.ExceptionHandler.throwExceptionForLottoNumbers
class Lotto(private val numbers: List<Int>) {

    init {
        throwExceptionForLottoNumbers(numbers)
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

}
