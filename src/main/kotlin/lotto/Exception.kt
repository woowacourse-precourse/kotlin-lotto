package lotto

import lotto.ErrorMessage.ERROR_NOT_NUMBERS
import lotto.ErrorMessage.ERROR_NOT_THOUSANDS

fun String.inputTypeException() {
    try {
        this.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(ERROR_NOT_NUMBERS)
    }
}

fun String.inputUnitException(){
    require(this.toInt() % 1000==0){ERROR_NOT_THOUSANDS}
}