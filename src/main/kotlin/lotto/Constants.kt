package lotto

// purchase I/O messages
const val LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요."

// exception messages
private const val ERROR_PREFIX = "[ERROR] "
const val LOTTO_AMOUNT_TYPE_EXCEPTION_MESSAGE = ERROR_PREFIX + "구입 금액 입력값이 숫자가 아닙니다."
const val LOTTO_AMOUNT_NEGATIVE_EXCEPTION_MESSAGE = ERROR_PREFIX + "구입 금액 입력값은 0보다 큰 숫자여야 합니다."
const val LOTTO_AMOUNT_UNIT_EXCEPTION_MESSAGE = ERROR_PREFIX + "구입 금액은 1,000원 단위여야 합니다."