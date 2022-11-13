package lotto.model

enum class Price(val reward : String) {
    THREE("(5,000원)"),
    FOUR("(50,000원)"),
    FIVE("(1,500,000원)"),
    FIVE_WITH_BONUS("(30,000,000원)"),
    SIX("(2,000,000,000원)"),
    COUNT("개를 구매했습니다. "),
    INPUT_PURCHASE_CENTENCE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계\n---\n")
}