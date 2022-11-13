package utils

//class Messages {
//    companion object {
//        const val BUY_PRICE_INQUIRE_MESSAGE = "구입금액을 입력해 주세요."
//        const val BUY_AMOUNT_MESSAGE = "개를 구매했습니다."
//        const val ANSWER_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
//        const val BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
//        const val STATICS_TITLE_MESSAGE = "당첨 통계"
//        const val STATICS_SPLITTER_MESSAGE = "---"
//        const val FIFTH_RANK_MESSAGE = "3개 일치 (5,000원) - ${.2f}"
//        const val FOURTH_RANK_MESSAGE = "4개 일치 (50,000원) - "
//        const val THIRD_RANK_MESSAGE = "5개 일치 (1,500,000원) - "
//        const val SECOND_RANK_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
//        const val FIRST_RANK_MESSAGE = "6개 일치 (2,000,000,000원) - "
//        const val STATICS_COUNT_MESSAGE = "개"
//        const val FIRST_RANK_MESSAGE = "6개 일치 (2,000,000,000원) - "
//    }
//}

object Messages {
    // 입력을 받기 위한 메세지
    const val BUY_PRICE_INQUIRE_MESSAGE = "구입금액을 입력해 주세요."
    const val BUY_AMOUNT_MESSAGE = "개를 구매했습니다."
    const val ANSWER_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
    const val BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
    
    // 통계를 위한 메세지
    const val STATICS_TITLE_MESSAGE = "당첨 통계"
    const val STATICS_SPLITTER_MESSAGE = "---"
//    const val FIFTH_RANK_MESSAGE = "3개 일치 (5,000원) - %d개"
    const val FIFTH_RANK_MESSAGE = "3개 일치 (5,000원) - "
    const val FOURTH_RANK_MESSAGE = "4개 일치 (50,000원) - "
    const val THIRD_RANK_MESSAGE = "5개 일치 (1,500,000원) - "
    const val SECOND_RANK_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
    const val FIRST_RANK_MESSAGE = "6개 일치 (2,000,000,000원) - "
    const val STATICS_COUNT_MESSAGE = "개"
    const val STATICS_REVENUE_MESSAGE = "총 수익률은 ${.1f}%입니다."

    // 에러 표기를 위한 메세지
    const val ERROR_PREFIX_MESSAGE = "[ERROR]"
    const val ERROR_LOTTO_INPUT = " 맞는 로또 금액을 제시해 주세요."
}