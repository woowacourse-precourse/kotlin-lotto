package data

enum class StringResource(val resource: String) {
    PURCHASE("구입금액을 입력해 주세요."),
    ERROR("[ERROR] 잘못된 값을 입력했습니다."),
    TICKETS("개를 구매했습니다."),
    INVALID("[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WINNING("\n당첨 번호를 입력해 주세요"),
    BONUS("\n보너스 번호를 입력해 주세요"),
    TOTAL("\n당첨 통계\n---")
}