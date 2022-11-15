package util

import constant.LOTTO_NUM_RANGE_END
import constant.LOTTO_NUM_RANGE_START
import exception.DivisibleMoneyException
import exception.InputCountException

enum class ErrorType {
    CANNOT_DIVISIBLE_MONEY, WRONG_TYPE_INPUT, WRONG_VALUE, WRONG_WIN_LOTTO_NUMBERS_COUNT,
    EMPTY_LOTTIES, OUT_OF_LOTTO_BOUNDS
}

fun ErrorType.parseErrorType(): String = when (this) {
    ErrorType.CANNOT_DIVISIBLE_MONEY -> "1,000원 단위로 입력해 주세요."
    ErrorType.WRONG_TYPE_INPUT -> "올바른 숫자를 입력해 주세요."
    ErrorType.WRONG_VALUE -> "입력이 올바르지 않습니다."
    ErrorType.WRONG_WIN_LOTTO_NUMBERS_COUNT -> "숫자를 모두 입력해 주세요."
    ErrorType.EMPTY_LOTTIES -> "로또를 먼저 구매해 주세요."
    ErrorType.OUT_OF_LOTTO_BOUNDS -> "${LOTTO_NUM_RANGE_START}부터 ${LOTTO_NUM_RANGE_END}까지의 숫자를 입력해 주세요."
}

fun showError(e: Exception) {
    printErrorMessage(
        when (e) {
            is DivisibleMoneyException -> ErrorType.CANNOT_DIVISIBLE_MONEY
            is NumberFormatException -> ErrorType.WRONG_TYPE_INPUT
            is InputCountException -> ErrorType.WRONG_WIN_LOTTO_NUMBERS_COUNT
            is UninitializedPropertyAccessException -> ErrorType.EMPTY_LOTTIES
            is ArrayIndexOutOfBoundsException -> ErrorType.OUT_OF_LOTTO_BOUNDS
            else -> ErrorType.WRONG_VALUE
        }
    )
}