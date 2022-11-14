package lotto

fun String.inputTypeException() {
    try {
        this.toInt()

    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBERS)
    }
}