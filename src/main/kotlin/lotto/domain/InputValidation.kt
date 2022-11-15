package lotto.domain

class InputValidation {

    fun checkInputInteger(input: String): Int {
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE)
        }
    }

    companion object {
        const val NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 정수를 입력해 주셔야 합니다."
    }
}