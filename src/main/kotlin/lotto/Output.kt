package lotto

enum class Output(val message: String) {
    PurchaseAmount("구입금액을 입력해 주세요."),
    WinningNumber("당첨 번호를 입력해 주세요."),
    BonusNumber("보너스 번호를 입력해 주세요."),
    NumberOfPurchases("개를 구매했습니다."),
    Result("당첨 통계"),

    ThreeMatch("3개 일치 (5,000원) - "),
    FourMatch("4개 일치 (50,000원) - "),
    FiveMatch("5개 일치 (1,500,000원) - "),
    FiveAndBonusMatch("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SixMatch("6개 일치 (2,000,000,000원) - "),

    EarningRate("총 수익률은 ")
}