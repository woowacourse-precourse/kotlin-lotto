package lotto

import util.Constants
import profit.ProfitCalculator
import profit.ProfitPrinter
import user.User
import winning.BonusNumber
import winning.WinningCalculator
import winning.WinningNumber
import winning.WinningPrinter

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
