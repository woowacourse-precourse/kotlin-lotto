package lotto

object Constants {
    /**
     * 안내 메시지
     */
    val INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요."
    val INPUT_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
    val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
    val SHOW_MATCH_STATISTICS_MESSAGE = "당첨 통계"

    val MATCH_THREE_NUMBER_MESSAGE = "3개 일치 (5,000원) - "
    val MATCH_FOUR_NUMBER_MESSAGE = "4개 일치 (50,000원) - "
    val MATCH_FIVE_NUMBER_MESSAGE = "5개 일치 (1,500,000원) - "
    val MATCH_FIVE_WITH_BONUS_NUMBER_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
    val MATCH_SIX_NUMBER_MESSAGE = "6개 일치 (2,000,000,000원) - "

    val ERROR_MESSAGE = "[ERROR]"
    val ERROR_WRONG_INPUT_FORM = "${ERROR_MESSAGE} 입력값이 올바른 형식이 아닙니다."
    val ERROR_LOTTO_NUMBER_DUPLICATED_NUMBER = "${ERROR_MESSAGE} 로또 번호는 서로 중복되지 않은 숫자여야 합니다."
    val ERROR_LOTTO_NUMBER_OVER_SIX_NUMBER = "${ERROR_MESSAGE} 로또 번호는 6개의 숫자여야 합니다."
    val ERROR_LOTTO_NUMBER_NOT_BETWEEN_ONE_AND_FORTYFIVE = "${ERROR_MESSAGE} 로또 번호는 1부터 45 사이의 숫자여야 합니다."

    val ERROR_BONUS_NUMBER_DUPLICATED_IN_LOTTO_NUMBERS = "${ERROR_MESSAGE} 보너스 번호는 입력했던 6개의 숫자와 중복되지 않아야 합니다."
    val ERROR_BONUS_NUMBER_NOT_BETWEEN_ONE_AND_FORTYFIVE = "${ERROR_MESSAGE} 보너스 번호는 1부터 45 사이의 숫자여야 합니다."

    val ERROR_PURCHASE_MONEY_NOT_THOUSAND_UNIT = "${ERROR_MESSAGE} 구입 금액은 1000원 단위여야 합니다."
    val ERROR_PURCHASE_MONEY_NOT_POSITIVE_NUMBER = "${ERROR_MESSAGE} 구입 금액은 0보다 커야 합니다."
}