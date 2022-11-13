package lotto.service.dto

import lotto.domain.Lotto

class LottoDto(lotto: Lotto) {

    private val numbers: List<Int>

    init {
        numbers = lotto.numbers().sorted()
    }

    fun numbers() = numbers
}