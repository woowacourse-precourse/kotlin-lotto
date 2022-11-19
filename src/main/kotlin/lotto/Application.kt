package lotto

import lotto.control.Controller
import lotto.control.ExceptionHandler
import lotto.message.Output

fun main() {
    val control = Controller()
    val amount = getInputLotteryAmount()
    control.getLotteryPaper(amount)
    val lotto = Lotto(getWinningNumber())
    val winningNumber = lotto.changeToElement()
    val bonusNumber = getBonusNumber(winningNumber)
    control.winningStatistics(winningNumber, bonusNumber)
    control.resultPrint()
    control.getYield(amount)
}

fun getInputLotteryAmount(): Int {
    Output.purchaseAmount()
    val amount = ExceptionHandler.checkNumber()
    ExceptionHandler.checkAmount(amount)
    println()
    return amount / 1000
}

fun getWinningNumber(): List<Int> {
    Output.winningNumber()
    val winningNumber = ExceptionHandler.checkNumbers()
    println()
    return winningNumber
}

fun getBonusNumber(winningNumber: List<Int>): Int {
    Output.bonusNumber()
    val number = ExceptionHandler.checkNumber()
    ExceptionHandler.checkBonusNumber(number, winningNumber)
    println()
    return number
}