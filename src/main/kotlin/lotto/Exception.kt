package lotto

import lotto.data.ErrorMessage.ERROR_NOT_COMMA
import lotto.data.ErrorMessage.ERROR_NOT_NUMBERS
import lotto.data.ErrorMessage.ERROR_NOT_THOUSANDS
import lotto.data.ErrorMessage.ERROR_NUM_NOT_IN_RANGE

fun String.inputTypeException() {
    try {
        this.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(ERROR_NOT_NUMBERS)
    }
}

fun String.inputUnitException() {
    require(this.toInt() % 1000 == 0) { ERROR_NOT_THOUSANDS }
}


fun Int.inputRangeException() {
    require(this in 1..45) { ERROR_NUM_NOT_IN_RANGE }
}

fun String.inputCommaException() {
    val input = this.chunked(1)
    for (index in input.indices) {
        require(this[index].code == 44 || this[index].code in 48..57) { ERROR_NOT_COMMA }
    }
}