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
    val winningList = WinningCalculator().getResult(lottoNumbers, winningNumber, bonusNumber)
    val rateOfProfit = ProfitCalculator().calcRateOfProfit(winningList, money)
    println()
    WinningPrinter(winningList).printWinning()
    ProfitPrinter().printProfit(rateOfProfit)
}
