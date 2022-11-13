package lotto.domain

import lotto.utils.LottoExceptionHandler.validateLottoNumberRange

class LottoNumber(val number: Int) {

    init {
        validateLottoNumberRange(number)
    }

    override fun toString() = number.toString()
    override fun equals(other: Any?): Boolean {
        if (other is LottoNumber) {
            return this.number == other.number
        }
        return false
    }
}