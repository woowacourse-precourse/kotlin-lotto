package lotto.util

enum class ErrorType {
    CANNOT_DIVISIBLE_INPUT, WRONG_TYPE_INPUT
}

fun ErrorType.parseErrorType(): String = when (this) {
    ErrorType.CANNOT_DIVISIBLE_INPUT -> "1,000원 단위로 입력해 주세요."
    ErrorType.WRONG_TYPE_INPUT -> "숫자를 입력해 주세요."
}

fun printErrorMessage(errorType: ErrorType) {
    println("[ERROR] ${errorType.parseErrorType()}")
}