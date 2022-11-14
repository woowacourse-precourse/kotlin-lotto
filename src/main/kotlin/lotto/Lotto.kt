package lotto

import lotto.LottoPhrases.DUPLICATE_LOTTO_NUMBER_ERROR

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        if (numbers.size != numbers.toSet().size) throw IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR)
    }

    fun getLottoNumbers(): List<Int> = numbers
}
