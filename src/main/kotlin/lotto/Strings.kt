package lotto

enum class ErrorStrings(val message: String) {
    INVALID_BONUS_NUMBER_ENTERED("[ERROR] 보너스 번호가 올바르게 입력되지 않음 "),
    INVALID_PURCHASE_AMOUNT_ENTERED("[ERROR] 구입 금액 입력이 올바르지 않음 "),
    INVALID_PURCHASE_AMOUNT_UNITS("[ERROR] 구입 금액이 1000원 단위가 아님 "),
    INVALID_WINNING_NUMBER_ENTERED("[ERROR] 당첨 번호 입력이 올바르지 않음 "),
    INVALID_PARAMETER("[ERROR] 잘못된 파라미터 전달"),
    DUPLICATION_NUMBER_BONUS_WINNING("[ERROR] 보너스 번호가 당첨 번호와 중복됨");
}

enum class MainStrings(val message: String) {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),

    GUIDE_WINNING_STATISTICS("당첨 통계\n---");
}

enum class MainAppendedStrings(val message: String) {
    GUIDE_PURCHASE_COUNT("개를 구매했습니다.") {
        override fun append(string: String) = "$string$message"
    };
    abstract fun append(string: String): String
}