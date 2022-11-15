package lotto.enum

enum class ErrorString(val string: String) {
    NOT_DIGIT("[ERROR] 숫자가 아닌 문자를 입력했습니다."),
    PURCHASE_AMOUNT_UNIT("[ERROR] 구입 금액은 ${Configuration.LOTTO_PRICE.number}원 단위로 입력해야 합니다."),
    OUT_OF_BOUND("[ERROR] 로또 번호는 ${Configuration.START_LOTTO_NUMBER.number}부터 " +
                "${Configuration.END_LOTTO_NUMBER.number} 사이의 숫자여야 합니다."),
    LOTTO_SIZE("[ERROR] 로또 번호는 ${Configuration.LOTTO_SIZE}개를 입력해야 합니다."),
    DUPLICATED_DRAWN_NUMBERS("[ERROR] 당첨 번호와 보너스 번호에 중복된 번호는 없어야 합니다.")
}