package lotto

// Buyer
const val ENTER_AMOUNT = "값을 입력해주세요."
const val ENTER_NUMBER = "숫자를 입력해주세요."
const val MUST_CAN_DIVIDED = "1000원으로 나누어 떨어져야 합니다."
const val WRONG_RANGE_AMOUNT = "구매 가능 최소 금액은 1000원, 구매 가능 최대 금액은 2147483000원입니다."
const val INPUT_FORMAT = "([0-9]{1,2}),([0-9]{1,2}),([0-9]{1,2}),([0-9]{1,2}),([0-9]{1,2}),([0-9]{1,2})"
const val FORMAT_ERROR = "올바른 입력 형식이 아닙니다. 숫자 6개를 쉼표로 구분해서 입력해주세요."
const val WRONG_RANGE_NUMBER = "1~45 사이가 아닌 숫자가 있습니다."
const val DUPLICATE_NUMBER = "중복되는 값이 있습니다."

// Number
const val ONE_THOUSAND = 1000
const val ZERO = 0
const val ONE_LOTTERY_COUNT = 6

// Printer
const val ENTER_BUY_AMOUNT = "구입금액을 입력해 주세요."
const val BOUGHT_COUNT = "\n%d개를 구매했습니다."
const val ENTER_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요."
const val ENTER_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
const val WINNING_STATICS = "\n당첨 통계\n---"
const val CORRECT_THREE = "3개 일치 (5,000원) - %d개\n"
const val CORRECT_FOUR = "4개 일치 (50,000원) - %d개\n"
const val CORRECT_FIVE = "5개 일치 (1,500,000원) - %d개\n"
const val CORRECT_FIVE_AND_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
const val CORRECT_SIX = "6개 일치 (2,000,000,000원) - %d개"
const val TOTAL_YIELD = "총 수익률은 %s%%입니다."
const val ERROR_MESSAGE = "[ERROR] %s"