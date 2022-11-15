package lotto

enum class ErrorStrings(val message: String) {
    INVALID_BONUS_NUMBER_ENTERED("[ERROR] 보너스 번호가 올바르게 입력되지 않음 "),
    INVALID_PURCHASE_AMOUNT_ENTERED("[ERROR] 구입 금액 입력이 올바르지 않음 "),
    INVALID_PURCHASE_AMOUNT_UNITS("[ERROR] 구입 금액이 1000원 단위가 아님 "),
    INVALID_WINNING_NUMBER_ENTERED("[ERROR] 당첨 번호 입력이 올바르지 않음 "),
    INVALID_PARAMETER("[ERROR] 잘못된 파라미터 전달"),
    DUPLICATION_NUMBER_BONUS_WINNING("[ERROR] 보너스 번호가 당첨 번호와 중복됨");

}