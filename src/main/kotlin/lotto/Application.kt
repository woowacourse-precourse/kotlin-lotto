package lotto

fun main() {
    val money = User().getMoney()
    val numberOfLotto = money / 1000
    val lottoNumbers = LottoGenerator().generateLotto(numberOfLotto)
    println()
    LottoPrinter().printLotto(lottoNumbers)
    println()
    val winningNumber = WinningNumber().getWinningNumber()
    println()
    val bonusNumber = BonusNumber().getBonusNumber(winningNumber)
    val winningList = GameManager().getResult(lottoNumbers, winningNumber, bonusNumber)
}
