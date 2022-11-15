package lotto.service.dto

import lotto.domain.Lotto

data class LottoDto(val numbers: List<Int>) {

    companion object {
        fun createFrom(lotto: Lotto): LottoDto = LottoDto(lotto.numbers().sorted())
    }
}