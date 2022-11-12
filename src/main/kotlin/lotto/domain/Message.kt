package lotto.domain

object Message {
    private const val INPUT_PURCHASING_AMOUNT = "구입금액을 입력해 주세요."
    private const val INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

    fun showInputPurchasingAmount() {
        println(INPUT_PURCHASING_AMOUNT)
    }
    fun showInputWinningNumber() {
        println(INPUT_WINNING_NUMBERS)
    }
    fun showInputBonusNumber() {
        println(INPUT_BONUS_NUMBER)
    }
    fun showCountOfLotto(countOfLotto: Int) {
        println("${countOfLotto}개를 구매했습니다.")
    }
    fun showPurchasedLottoNumbers(lottoNumbers: MutableList<Lotto>) {
        for (lottoNumber in lottoNumbers) {
            println(lottoNumber.toString())
        }
    }
}