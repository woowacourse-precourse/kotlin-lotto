package lotto.data

enum class Message(val message: String) {
    ENTER_PAYMENT("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ENTER_BOUNS_NUMBER("보너스 번호를 입력해 주세요."),
    PAYMENT_RULE("[ERROR] 로또는 1,000원 단위로 구입 가능합니다."),
    LOTTO_NUMBER_RULE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
}