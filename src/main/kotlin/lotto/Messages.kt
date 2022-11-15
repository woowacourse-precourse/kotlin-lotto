package lotto

class Messages {
    companion object {
        const val NUMBER_INPUT_ERROR = "[ERROR] 숫자만 입력해 주세요."
        const val DIVISION_ERROR = "[ERROR] 1000원으로 나눠지지 않습니다."
        const val NUMBER_RANGE_ERROR = "[ERROR] 로또 번호 범위(1~45)를 벗어났습니다."
        const val DUPLICATE_NUMBER_ERROR = "[ERROR] 당첨 번호와 중복됩니다."
        const val PAYMENT_INPUT_MESSAGE = "구입금액을 입력해 주세요."
        const val NUMBER_OF_LOTTOS_MESSAGE = "%d개를 구매했습니다."
        const val WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요."
        const val BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요."
        const val STATS_TITLE = "당첨 통계\n---"
        const val FIFTH_PRIZE_RESULT = "3개 일치 (5,000원) - %d개"
        const val FORTH_PRIZE_RESULT = "4개 일치 (50,000원) - %d개"
        const val THIRD_PRIZE_RESULT = "5개 일치 (1,500,000원) - %d개"
        const val SECOND_PRIZE_RESULT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
        const val FIRST_PRIZE_RESULT = "6개 일치 (2,000,000,000원) - %d개"
        const val EARNINGS_RATE_MESSAGE = "총 수익률은 %s%%입니다."
    }
}