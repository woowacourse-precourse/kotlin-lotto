package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("구입금액을 입력해 주세요.")
    val buyAmount = userInput()
    buyAmountException(buyAmount)

    val lottoCnt = lottoCnt(buyAmount.toInt())
    println("\n${lottoCnt}개를 구매했습니다.")

    val myLotto = getLotto(lottoCnt)
    printLotto(myLotto)

    println("\n당첨 번호를 입력해 주세요.")
    val lottoResult = userInput().split(",").map { it.toInt() }

    println("\n보너스 번호를 입력해 주세요.")
    val bonusNumber = userInput().toInt()
}

fun userInput(): String = Console.readLine()

fun lottoCnt(buyAmount: Int): Int = buyAmount / 1000

fun getLotto(lottoCnt: Int): List<List<Int>> {
    val myLotto = mutableListOf<List<Int>>()

    repeat(lottoCnt) {
        myLotto.add(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }

    return myLotto
}

fun printLotto(myLotto: List<List<Int>>) {
    myLotto.forEach {
        println(it)
    }
}

fun buyAmountException(buyAmount: String) {
    if(!buyAmount.chars().allMatch { Character.isDigit(it) }) {
        throw IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.")
    }

    if(buyAmount.toInt() % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 입력은 1000단위로만 가능합니다.")
    }
}