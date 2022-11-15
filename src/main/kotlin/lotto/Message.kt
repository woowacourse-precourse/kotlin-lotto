package lotto

enum class sendMessage(val message: String) {
    messageMoney("구입금액을 입력해 주세요."),
    messageNumber("당첨 번호를 입력해 주세요."),
    messageBonus("보너스 번호를 입력해 주세요."),
    messageCount("개를 구매했습니다."),
    messageResult("당첨 통계"),
    messageEarning("총 수익률은 "),
    grade5("3개 일치 (5,000원) - "),
    grade4("4개 일치 (50,000원) - "),
    grade3("5개 일치 (1,500,000원) - "),
    grade2("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    grade1("6개 일치 (2,000,000,000원) - ");
}