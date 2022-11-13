package lotto

fun main() {
    val lotto = Lotto(List(6) { 0 })
    val amount = getInputLotteryAmount()
    lotto.getLotteryPaper(amount)
    val winningNumber = getWinningNumber()
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