package lotto.domain

import lotto.domain.LottoExceptionHandler.validateLottoNumberDuplication
import lotto.domain.LottoExceptionHandler.validateLottoSize

class Lotto(private val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {
    init {
        validateLottoSize(this)
        validateLottoNumberDuplication(this)
    }

    override fun toString(): String =
        numbers.joinToString(", ", "[", "]")
}
