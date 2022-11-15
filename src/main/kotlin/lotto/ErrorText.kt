package lotto


private const val ERROR_TEXT = "[ERROR]"

enum class LottoErrorText(val errorText: String) {
    ENTER_SIX_NUMBERS("$ERROR_TEXT 번호를 6개만 입력해주세요"),
    ENTER_WITHOUT_DUPLICATES_DIGITS("$ERROR_TEXT 로또 번호를 중복 없이 입력해주세요"),
    ENTER_ONLY_NUMBERS_FROM_ONE_TO_FORTY_FIVE("$ERROR_TEXT 1부터 45까지의 수만 입력해주세요")
}

enum class BonusNumberErrorText(val errorText: String) {
    ENTER_ONLY_NUMBERS_FROM_ONE_TO_FORTY_FIVE("$ERROR_TEXT 1부터 45까지의 수만 입력해주세요"),
    ENTER_WITHOUT_DUPLICATES_DIGITS("$ERROR_TEXT 로또 번호를 중복 없이 입력해주세요")
}

enum class PurchaseAmountErrorText(val errorText: String) {
    SET_UP_PAYMENT_UNIT("$ERROR_TEXT 1000원 단위로만 입력해주세요")
}

enum class ErrorFormatText(val errorText: String) {
    ENTER_ACCORDING_TO_THE_FORMAT("[ERROR] 형식에 맞지 않는 문자를 사용하였습니다.")
}

