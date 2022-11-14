package lotto

import Util.Constants

fun main() {
    val money = User().getMoney()
    val numberOfLotto = money / Constants.UNIT_OF_MONEY.constant
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
