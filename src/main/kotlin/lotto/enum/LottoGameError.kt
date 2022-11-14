package lotto.enum

enum class LottoGameError(val string: String) {
    NOT_DIGIT("[Error] 숫자가 아닌 문자를 입력했습니다."),
    PURCHASE_AMOUNT_UNIT("[Error] 구입 금액은 1000원 단위로 입력해야 합니다."),
    OUT_OF_BOUND("[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
}