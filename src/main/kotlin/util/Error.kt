package util

enum class Error(val message: String) {
    NUMBER_FORMAT_ERROR("[ERROR] 숫자 형식으로 입력해야 합니다."),
    MONEY_UNIT_ERROR("[ERROR] 1000원 단위로 입력해야 합니다."),
    NUMBER_OF_LOTTO_ERROR("[ERROR] 숫자 6개를 입력해야 합니다."),
    LOTTO_RANGE_ERROR("[ERROR] 1~45까지의 숫자로 입력해야 합니다."),
    LOTTO_DUPLICATION_ERROR("[ERROR] 중복되는 숫자가 없어야 합니다."),
    BONUS_NUMBER_DUPLICATION_ERROR("[ERROR] 당첨 번호와 중복되는 숫자가 없어야 합니다.")
}