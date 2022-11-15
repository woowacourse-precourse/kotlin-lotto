package lotto

class Message {
    companion object {
        const val NOT_THOUSANDS_NUMBER_MESSAGE = "[ERROR] 입력된 금액이 1000원단위여야 합니다."
        const val NOT_SIX_NUMBERS_MESSAGE = "[ERROR] 입력된 수가 6자리가 아닙니다."
        const val DUPLICATED_NUMBERS_MESSAGE = "[ERROR] 중복된 숫자가 있습니다."
        const val NOT_NUMBER_MESSAGE = "[ERROR] 입력된 수가 로또번호가 아닙니다."
        const val PUTIN_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
        const val PUT_IN_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해주세요."
        const val NUMBER_IS_DUPLICATED_MESSAGE = "[ERROR] 당첨된 번호와 보너스번호가 중복입니다."

        const val BUY_LOTTO_MESSAGE = "개를 구매했습니다."
        const val INPUT_MONEY_MESSAGE = "구입 금액을 입력해주세요"
        const val STATISTIC_MESSAGE = "당첨 통계"
        const val DASH_MESSAGE = "---"
        const val FRONT_PROFITS_MESSAGE = "총 수익률은 "
        const val END_PROFITS_MESSAGE = "%입니다."

        const val THREE_MATCH_MESSAGE = "3개 일치 (5,000원) - "
        const val FOUR_MATCH_MESSAGE = "4개 일치 (50,000원) - "
        const val FIVE_MATCH_MESSAGE = "5개 일치 (1,500,000원) - "
        const val FIVE_AND_BONUS_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
        const val SIX_MATCH_MESSAGE = "6개 일치 (2,000,000,000원) - "
        const val MATCH_END_MESSAGE = "개"

        const val UNIT_DELIMETER = ","
        const val FORMATTING = "%.1f"
    }
}