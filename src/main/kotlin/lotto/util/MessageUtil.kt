package lotto.util

enum class ErrorType{
    WRONG_MONEY_INPUT
}

fun ErrorType.parseErrorType(): String = when(this){
    ErrorType.WRONG_MONEY_INPUT -> "1,000원 단위로 입력해 주세요."
}

fun printErrorMessage(errorType: ErrorType){
    println("[ERROR] ${errorType.parseErrorType()}")
}