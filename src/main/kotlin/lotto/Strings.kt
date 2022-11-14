package lotto

// Error Message
const val ERROR_MESSAGE_ONLY_NUMBER = "[ERROR] 숫자만 입력할 수 있습니다."
const val ERROR_MESSAGE_ONLY_SIX_NUMBER = "[ERROR] 6개의 숫자만 입력할 수 있습니다."
const val ERROR_MESSAGE_NUMBER_OUT_RANGE = "[ERROR] 1~45 범위의 숫자만 입력할 수 있습니다."
const val ERROR_MESSAGE_INPUT_FORMAT = "[ERROR] 입력 형식이 잘못되었습니다."
const val ERROR_MESSAGE_ONLY_UNIT_1000 = "[ERROR] 1000원 단위의 금액만 지불이 가능합니다."

// Require Message
const val REQUIRE_MESSAGE_LOTTO_PRICE = "구입금액을 입력해 주세요."
const val REQUIRE_MESSAGE_JACKPOT_NUMBER = "당첨 번호를 입력해 주세요."
const val REQUIRE_MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

// Coincidence List Index
const val INDEX_THREE_COINCIDENCE: Int = 0
const val INDEX_FOUR_COINCIDENCE: Int = 1
const val INDEX_FIVE_COINCIDENCE: Int = 2
const val INDEX_FIVE_AND_BONUS_COINCIDENCE: Int = 3
const val INDEX_SIX_COINCIDENCE: Int = 4

// Jackpot Price
const val PRICE_THREE_COINCIDENCE: Long = 5000
const val PRICE_FOUR_COINCIDENCE: Long = 50000
const val PRICE_FIVE_COINCIDENCE: Long = 1500000
const val PRICE_FIVE_AND_BONUS_COINCIDENCE: Long = 30000000
const val PRICE_SIX_COINCIDENCE: Long = 2000000000