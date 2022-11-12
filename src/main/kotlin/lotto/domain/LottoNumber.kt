package lotto.domain

import lotto.domain.LottoExceptionHandler.validateLottoNumberRange

class LottoNumber(val number: Int) {

    init {
        validateLottoNumberRange(number)
    }

}