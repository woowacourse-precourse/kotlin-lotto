package message

enum class Message(val message: String) {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    COUNT("개를 구매했습니다."),
    INPUT_WINNING_NUM("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUM("보너스 번호를 입력해 주세요."),
    RATE("당첨 통계");
}
