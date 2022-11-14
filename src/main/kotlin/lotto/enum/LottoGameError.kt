package lotto.enum

enum class LottoGameError(val string: String) {
    NOT_DIGIT("[Error] 숫자가 아닌 문자를 입력했습니다."),
    PURCHASE_AMOUNT_UNIT("[Error] 구입 금액은 ${LottoGameConfiguration.LOTTO_PRICE.number}원 단위로 입력해야 합니다."),
    OUT_OF_BOUND("[Error] 로또 번호는 ${LottoGameConfiguration.START_LOTTO_NUMBER.number}부터 " +
                "${LottoGameConfiguration.END_LOTTO_NUMBER.number} 사이의 숫자여야 합니다."),
    LOTTO_SIZE("[Error] 로또 번호는 ${LottoGameConfiguration.LOTTO_SIZE}개를 입력해야 합니다.")
}