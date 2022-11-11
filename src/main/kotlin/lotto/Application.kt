package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    val buyAmount = userInput().toInt()
    val lottoCnt = lottoCnt(buyAmount)
}

fun userInput(): String = Console.readLine()

fun lottoCnt(buyAmount: Int): Int = buyAmount / 1000