package lotto.utils

import lotto.domain.LottoExceptionHandler.validateIntType

object Separator {

    fun separateToInts(sentence: String, delimiters: Char): List<Int> = sentence.split(delimiters)
        .map { number ->
            validateIntType(number)
            number.toInt()
        }
}