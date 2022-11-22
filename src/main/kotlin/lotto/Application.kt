package lotto

import util.Constants
import profit.ProfitCalculator
import profit.ProfitPrinter
import user.User
import winning.BonusNumberInput
import winning.WinningCalculator
import winning.WinningNumberInput
import winning.WinningPrinter

fun main() {
    val money = User().getMoney()
    val numberOfLotto = money / Constants.UNIT_OF_MONEY.constant
    val lottoNumbers = LottoGenerator().generateLotto(numberOfLotto)
    println()
    LottoPrinter().printLotto(lottoNumbers)
    println()
    val winningNumber = WinningNumberInput().getWinningNumber()
    println()
    val bonusNumber = BonusNumberInput().getBonusNumber(winningNumber)
    val winningList = WinningCalculator().getResult(lottoNumbers, winningNumber, bonusNumber)
    val rateOfProfit = ProfitCalculator().calcRateOfProfit(winningList, money)
    println()
    WinningPrinter(winningList).printWinning()
    ProfitPrinter().printProfit(rateOfProfit)
}
