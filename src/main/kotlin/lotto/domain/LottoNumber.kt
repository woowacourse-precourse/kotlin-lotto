package lotto.domain

import lotto.utils.LottoExceptionHandler.validateLottoNumberRange

class LottoNumber(val number: Int) {

    init {
        validateLottoNumberRange(number)
    }

    override fun toString() = number.toString()
}