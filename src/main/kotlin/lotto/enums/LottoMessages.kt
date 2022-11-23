package lotto.enums

enum class LottoMessages(private val messages: String) {
    INPUT_PURCHASING_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    STATS("당첨 통계"),
    DIVIDER("---"),
    HIT_THREE("3개 일치 (5,000원)"),
    HIT_FOUR("4개 일치 (50,000원)"),
    HIT_FIVE("5개 일치 (1,500,000원)"),
    HIT_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    HIT_SIX("6개 일치 (2,000,000,000원)"),
    TOTAL_INCOME_IS("총 수익률은");

    override fun toString(): String = messages
}