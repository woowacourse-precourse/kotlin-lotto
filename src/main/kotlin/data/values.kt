package data

// Error Message
const val ERROR_MESSAGE_ONLY_NUMBER = "[ERROR] 숫자만 입력할 수 있습니다."
const val ERROR_MESSAGE_ONLY_SIX_NUMBER = "[ERROR] 로또 번호는 6개의 숫자입니다."
const val ERROR_MESSAGE_NUMBER_OUT_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
const val ERROR_MESSAGE_INPUT_FORMAT = "[ERROR] 입력 형식이 잘못되었습니다."
const val ERROR_MESSAGE_ONLY_UNIT_1000 = "[ERROR] 로또 구입시 지불하는 금액은 1000원 단위여야 합니다."
const val ERROR_MESSAGE_NOT_DUPLICATION = "[ERROR] 로또의 번호는 중복될 수 없습니다."

// Require Message
const val REQUIRE_MESSAGE_LOTTO_PRICE = "구입금액을 입력해 주세요."
const val REQUIRE_MESSAGE_JACKPOT_NUMBER = "당첨 번호를 입력해 주세요."
const val REQUIRE_MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

// Print Message
var purchasesNumber: Int = 0
var PRINT_MESSAGE_PURCHASES_NUMBER = "${purchasesNumber}개를 구매했습니다."

// Coincidence List Index
const val INDEX_THREE_COINCIDENCE: Int = 0
const val INDEX_FOUR_COINCIDENCE: Int = 1
const val INDEX_FIVE_COINCIDENCE: Int = 2
const val INDEX_FIVE_AND_BONUS_COINCIDENCE: Int = 3
const val INDEX_SIX_COINCIDENCE: Int = 4

// Jackpot Prize
const val PRIZE_THREE_COINCIDENCE: Int = 5000
const val PRIZE_FOUR_COINCIDENCE: Int = 50000
const val PRIZE_FIVE_COINCIDENCE: Int = 1500000
const val PRIZE_FIVE_AND_BONUS_COINCIDENCE: Int = 30000000
const val PRIZE_SIX_COINCIDENCE: Int = 2000000000