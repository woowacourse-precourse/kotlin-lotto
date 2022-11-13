package lotto.util

object Constants {
    const val DEFAULT_NUMBER = 0
    const val LOTTO_MIN_NUMBER = 1
    const val LOTTO_MAX_NUMBER = 45
    const val LOTTO_UNIT_NUMBER = 1_000

    const val WINNING_NUMBER_COUNT = 6

    const val THREE_COINCIDE_WINNING_PRIZE_NUMBER = 5_000
    const val FOUR_COINCIDE_WINNING_PRIZE_NUMBER = 50_000
    const val FIVE_COINCIDE_WINNING_PRIZE_NUMBER = 1_500_000
    const val FIVE_AND_BONUS_COINCIDE_WINNING_PRIZE_NUMBER = 30_000_000
    const val SIX_COINCIDE_WINNING_PRIZE_NUMBER = 2_000_000_000

    const val LOTTO_RESULT_THREE_COINCIDE = "3개 일치 (5,000원) - %d개"
    const val LOTTO_RESULT_FOUR_COINCIDE = "4개 일치 (50,000원) - %d개"
    const val LOTTO_RESULT_FIVE_COINCIDE = "5개 일치 (1,500,000원) - %d개"
    const val LOTTO_RESULT_FIVE_AND_BONUS_COINCIDE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
    const val LOTTO_RESULT_SIX_COINCIDE = "6개 일치 (2,000,000,000원) - %d개"

    const val ERROR_MESSAGE_HEADER = "[ERROR] "
    const val ERROR_MESSAGE_BODY_NUMBER_SHOULD_BE_IN_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_MESSAGE_BODY_NUMBER_SHOULD_BE_DIVIDED_BY_UNIT = "구입 금액은 1,000원 단위로 입력해야 합니다."
    const val TOTAL_PUBLISHED_LOTTO_NUMBER = "\n%d개를 구매했습니다."
    const val TOTAL_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다."

    const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    const val INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요."
    const val INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
    const val WINNING_STATS = "\n당첨 통계\n---"
}