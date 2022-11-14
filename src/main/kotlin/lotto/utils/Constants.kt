package lotto.utils

object Constants {
    const val ERROR_MESSAGE = "[ERROR]"
    const val MIN_LOTTO_NUM = 1
    const val MAX_LOTTO_NUM = 45
    const val LOTTO_LENGTH = 6
    const val ZERO = 0

    // Input 메시지
    const val INPUT_PURCHASE_PRIZE_TEXT = "구매금액을 입력해 주세요."
    const val INPUT_WINNING_NUMBER_TEXT = "당첨 번호를 입력해 주세요."
    const val INPUT_BONUS_NUMBER_TEXT = "보너스 번호를 입력해 주세요."

    // 당첨 금액
    const val PRIZE_THREE = 5_000
    const val PRIZE_FOUR = 50_000
    const val PRIZE_FIVE = 1_500_000
    const val PRIZE_FIVE_BONUS = 30_000_000
    const val PRIZE_SIX = 2_000_000_000

    // 에러 메시지
    const val LOTTO_NUM_MUST_NUMBER_TEXT = "$ERROR_MESSAGE 로또 번호는 숫자로 입력해 주세요."
    const val LOTTO_NUM_IN_RANGE_TEXT = "$ERROR_MESSAGE 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val MONEY_MUST_NUMBER_TEXT = "$ERROR_MESSAGE 로또 구입 금액은 숫자로 입력해 주세요."
    const val MONEY_UNIT_NOT_CORRECT_TEXT = "$ERROR_MESSAGE 1,000원 단위로 입력해 주세요."
    const val BONUS_NOT_DUPLICATE_TEXT = "$ERROR_MESSAGE 보너스 번호와 당첨 번호는 중첩될 수 없습니다."
    const val LOTTO_LENGTH_MUST_SIX_TEXT = "$ERROR_MESSAGE 로또의 길이는 6이여야 합니다."
    const val LOTTO_NOT_DUPLICATE_TEXT = "$ERROR_MESSAGE 로또 번호는 중복된 숫자가 없어야 합니다."
}