package lotto

object Constants {
    val INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
    val INPUT_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
    val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."

    val MATCH_THREE_NUMBER_MESSAGE = "3개 일치 (5,000원) - "
    val MATCH_FOUR_NUMBER_MESSAGE = "4개 일치 (50,000원) - "
    val MATCH_FIVE_NUMBER_MESSAGE = "5개 일치 (1,500,000원) - "
    val MATCH_FIVE_WITH_BONUS_NUMBER_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
    val MATCH_SIX_NUMBER_MESSAGE = "6개 일치 (2,000,000,000원) - "

    val ERROR_WRONG_INPUT_FORM = "[ERROR] 입력값이 올바른 형식이 아닙니다."
    val ERROR_DUPLICATED_NUMBER = "[ERROR] 로또 번호는 서로 중복되지 않은 숫자여야 합니다."
    val ERROR_OVER_SIX_NUMBER = "[ERROR] 로또 번호는 6개의 숫자여야 합니다."
    val ERROR_NOT_BETWEEN_ONE_AND_FORTYFIVE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
}