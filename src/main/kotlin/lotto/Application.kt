package lotto

fun main() {
    val lotto = Lotto(List(6) { 0 })
    val amount = getInputLotteryAmount()
    lotto.getLotteryPaper(amount)
    val winningNumber = getWinningNumber()
    val bonusNumber = getBonusNumber(winningNumber)
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
    ExceptionHandler.checkWinningNumber(winningNumber)
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