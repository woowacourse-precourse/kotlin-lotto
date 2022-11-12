package lotto.domain

import lotto.domain.LottoExceptionHandler.validateLottoNumberDuplication

class Lotto(private val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {
    init {
        validateLottoNumberDuplication(this)
    }

    override fun toString(): String =
        numbers.joinToString(", ", "[", "]")
}
