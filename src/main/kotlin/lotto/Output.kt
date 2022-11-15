package lotto

enum class Output(val message: String) {
    PurchaseAmount("구입금액을 입력해 주세요."),
    WinningNumber("당첨 번호를 입력해 주세요."),
    BonusNumber("보너스 번호를 입력해 주세요."),
    NumberOfPurchases("개를 구매했습니다."),
    Result("당첨 통계")
}