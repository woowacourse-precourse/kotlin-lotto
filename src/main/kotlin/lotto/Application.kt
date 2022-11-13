package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    getInputLotteryAmount()
}

fun getInputLotteryAmount(): Int {
    Output.purchaseAmount()
    val amount = ExceptionHandler.checkNumber()
    ExceptionHandler.checkAmount(amount)
    println()
    return amount / 1000
}