package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    getInputLotteryAmount()
}

fun getInputLotteryAmount(): Int {
    val amount = Console.readLine().toInt()
    println()
    return amount / 1000
}