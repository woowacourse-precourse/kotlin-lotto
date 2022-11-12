package lotto.util

import lotto.exception.DivisibleMoneyException
import lotto.exception.InputCountException

enum class ErrorType {
    CANNOT_DIVISIBLE_MONEY, WRONG_TYPE_INPUT, WRONG_VALUE, WRONG_WIN_LOTTO_NUMBERS_COUNT
}

fun ErrorType.parseErrorType(): String = when (this) {
    ErrorType.CANNOT_DIVISIBLE_MONEY -> "1,000원 단위로 입력해 주세요."
    ErrorType.WRONG_TYPE_INPUT -> "올바른 숫자를 입력해 주세요."
    ErrorType.WRONG_VALUE -> "입력이 올바르지 않습니다."
    ErrorType.WRONG_WIN_LOTTO_NUMBERS_COUNT -> "숫자를 모두 입력해 주세요."
}

fun showError(e: Exception) {
    when (e) {
        is DivisibleMoneyException -> {
            printErrorMessage(ErrorType.CANNOT_DIVISIBLE_MONEY)
        }
        is NumberFormatException -> {
            printErrorMessage(ErrorType.WRONG_TYPE_INPUT)
        }
        is InputCountException -> {
            printErrorMessage(ErrorType.WRONG_WIN_LOTTO_NUMBERS_COUNT)
        }
        else -> {
            printErrorMessage(ErrorType.WRONG_VALUE)
        }
    }
}