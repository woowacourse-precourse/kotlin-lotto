package util

enum class Error (val message: String) {
    INPUT_TYPE_ERROR("[ERROR] 구입 금액은 숫자여야 합니다."),
    INPUT_UNIT_ERROR("[ERROR] 구입 금액은 1,000원 단위로 입력되어야 합니다."),
    INPUT_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INPUT_SIX_NUMBER_ERROR("[ERROR] 로또 번호는 6개를 입력해야 합니다."),
    INPUT_ONE_NUMBER_ERROR("[ERROR] 보너스 번호는 1개를 입력해야 합니다.")
}