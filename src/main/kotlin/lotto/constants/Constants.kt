package lotto.constants

const val START_MESSAGE = "구입금액을 입력해 주세요."
const val BUY_MESSAGE = "개를 구매했습니다."
const val WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
const val BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
const val WINNING_STATISTICS = "당첨 통계\n---"
val RESULT_MESSAGES = listOf(
    "3개 일치 (5,000원)", "4개 일치 (50,000원)", "5개 일치 (1,500,000원)",
    "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)"
)
const val EARNINGS_RATE = "총 수익률은 "
const val ERROR_MESSAGE = "[ERROR] "
const val ERROR_NOT_NUMBER = "숫자가 아닌 입력이 있습니다."
const val ERROR_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다."
const val ERROR_DUPLICATION = "잘못된 입력입니다."
const val ERROR_WRONG_MONEY = "1000원 단위의 금액이어야 합니다."