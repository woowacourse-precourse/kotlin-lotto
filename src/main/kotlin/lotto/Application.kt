package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val buyAmount = userInput().toInt()
    val lottoCnt = lottoCnt(buyAmount)
    val myLotto = getLotto(lottoCnt)
}

fun userInput(): String = Console.readLine()

fun lottoCnt(buyAmount: Int): Int = buyAmount / 1000

fun getLotto(lottoCnt: Int): List<List<Int>> {
    val myLotto = mutableListOf(listOf<Int>())

    repeat(lottoCnt) {
        myLotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }

    return myLotto
}