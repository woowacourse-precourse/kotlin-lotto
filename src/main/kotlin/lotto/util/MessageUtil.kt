package lotto.util

enum class ErrorType {
    CANNOT_DIVISIBLE_MONEY, WRONG_TYPE_INPUT, EMPTY_VALUE
}

fun ErrorType.parseErrorType(): String = when (this) {
    ErrorType.CANNOT_DIVISIBLE_MONEY -> "1,000원 단위로 입력해 주세요."
    ErrorType.WRONG_TYPE_INPUT -> "숫자를 입력해 주세요."
    ErrorType.EMPTY_VALUE -> "입력이 올바르지 않습니다."
}

fun printErrorMessage(errorType: ErrorType) {
    println("[ERROR] ${errorType.parseErrorType()}")
}