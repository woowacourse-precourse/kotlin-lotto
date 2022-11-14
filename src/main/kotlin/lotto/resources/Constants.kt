package lotto.resources

// FOR INPUT VIEW
const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
const val INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

// FOR OUTPUT VIEW
const val OUTPUT_BOUGHT_TICKETS = "%d개를 구매했습니다."
const val OUTPUT_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다."
const val OUTPUT_WINNING_STATS = "당첨 통계\n----"
const val OUTPUT_FIFTH_PLACE = "3개 일치 (5,000원) - %d개"
const val OUTPUT_FOURTH_PLACE = "4개 일치 (50,000원) - %d개"
const val OUTPUT_THIRD_PLACE = "5개 일치 (1,500,000원) - %d개"
const val OUTPUT_SECOND_PLACE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
const val OUTPUT_FIRST_PLACE = "6개 일치 (2,000,000,000원) - %d개"

// FOR ERROR HANDLING
private const val ERROR_MESSAGE_PREFIX = "[ERROR] "
const val ERROR_INPUT_VALUE_SIX_ONLY = ERROR_MESSAGE_PREFIX + "입력은 6개만 있어야합니다."
const val ERROR_INPUT_VALUE_NO_DUPLICATES = ERROR_MESSAGE_PREFIX + "중복된 숫자가 있으면 안됩니다."
const val ERROR_INPUT_VALUE_ONE_OR_FORTY_FIVE_ONLY = ERROR_MESSAGE_PREFIX + "입력은 6개만 있어야합니다."
const val ERROR_INPUT_VALUE_NUMBER_ONLY = ERROR_MESSAGE_PREFIX + "숫자만 입력해주세요."
const val ERROR_INPUT_VALUE_MULTIPLE_OF_THOUSAND_ONLY = ERROR_MESSAGE_PREFIX + "천원 단위로만 입력해주세요."
const val ERROR_INPUT_VALUE_POSITIVE_NUMBER_ONLY = ERROR_MESSAGE_PREFIX + "자연수만 입력해주세요."

// FOR LOTTO LOGIC
const val LOTTO_START_NUMBER = 1
const val LOTTO_END_NUMBER = 45
const val LOTTO_NUMBER_COUNT = 6
const val LOTTO_TICKET_PRICE = 1000
const val LOTTO_FIRST_PRIZE = 2_000_000_000
const val LOTTO_SECOND_PRIZE = 30_000_000
const val LOTTO_THIRD_PRIZE = 1_500_000
const val LOTTO_FOURTH_PRIZE = 50_000
const val LOTTO_FIFTH_PRIZE = 5_000
const val LOTTO_NONE_PRIZE = 0
