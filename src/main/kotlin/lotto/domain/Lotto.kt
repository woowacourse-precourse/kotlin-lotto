package lotto.domain

import lotto.utils.LottoExceptionHandler.validateLottoNumberDuplication
import lotto.utils.LottoExceptionHandler.validateLottoSize

class Lotto(private val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {

    init {
        validateLottoSize(this)
        validateLottoNumberDuplication(this)
    }

    override fun toString(): String =
        numbers.joinToString(", ", "[", "]")
}
