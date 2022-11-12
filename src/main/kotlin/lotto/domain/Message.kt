package lotto.domain

object Message {
    fun showInputPurchasingAmount() {
        println("구입금액을 입력해 주세요.")
    }
    fun showInputWinningNumber() {
        println("당첨 번호를 입력해 주세요.")
    }
    fun showInputBonusNumber() {
        println("보너스 번호를 입력해 주세요.")
    }
    fun showCountOfLotto(countOfLotto: Int) {
        println("${countOfLotto}개를 구매했습니다.")
    }
}