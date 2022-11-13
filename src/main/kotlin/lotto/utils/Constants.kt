package lotto.utils

// purchase I/O messages
const val LOTTO_PURCHASE_MESSAGE = "구입금액을 입력해 주세요."
const val LOTTO_PURCHASE_LOTTO_COUNT_MESSAGE= "%d개를 구매했습니다."
const val WINNING_LOTTO_ENTER_MESSAGE = "당첨 번호를 입력해 주세요."
const val BONUS_NUMBER_ENTER_MESSAGE = "보너스 번호를 입력해 주세요."

// exception messages
private const val ERROR_PREFIX = "[ERROR] "
const val INTEGER_TYPE_EXCEPTION_MESSAGE = ERROR_PREFIX + "입력값이 숫자가 아닙니다."
const val LOTTO_AMOUNT_NEGATIVE_EXCEPTION_MESSAGE = ERROR_PREFIX + "구입 금액 입력값은 0보다 큰 숫자여야 합니다."
const val LOTTO_AMOUNT_UNIT_EXCEPTION_MESSAGE = ERROR_PREFIX + "구입 금액은 1,000원 단위여야 합니다."
const val LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE = ERROR_PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다."
const val LOTTO_SIZE_EXCEPTION_MESSAGE = ERROR_PREFIX + "로또는 6개의 숫자로 구성되어야 합니다."
const val LOTTO_NUMBER_DUPLICATION_EXCEPTION_MESSAGE = ERROR_PREFIX + "중복된 로또 번호가 포함되어 있습니다."
const val BONUS_NUMBER_DUPLICATION_EXCEPTION_MESSAGE = ERROR_PREFIX + "보너스 번호와 중복되는 당첨 번호가 존재합니다."

// lotto
const val LOTTO_START_NUMBER = 1
const val LOTTO_END_NUMBER = 45
const val LOTTO_SIZE = 6