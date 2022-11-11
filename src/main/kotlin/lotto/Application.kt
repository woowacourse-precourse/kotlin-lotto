package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    try {
        println("구입금액을 입력해 주세요.")
        val buyAmount = userInput().toInt()
        buyAmountException(buyAmount)

        val lottoCnt = lottoCnt(buyAmount)
        println("\n${lottoCnt}개를 구매했습니다.")

        val myLotto = getLotto(lottoCnt)
        printLotto(myLotto)

        println("\n당첨 번호를 입력해 주세요.")
        val lottoResult = userInput().split(",").map { it.toInt() }
        lottoException(lottoResult)

        println("\n보너스 번호를 입력해 주세요.")
        val bonusNumber = userInput().toInt()
        bonusNumberException(lottoResult, bonusNumber)

        val win = checkLotto(lottoResult, myLotto, bonusNumber)
    }
    catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.")
    }
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

fun buyAmountException(buyAmount: Int) {
    if(buyAmount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 입력은 1000단위로만 가능합니다.")
    }
}

fun lottoException(lottoResult: List<Int>) = Lotto(lottoResult).lottoException()

fun bonusNumberException(lottoResult: List<Int>, bonusNumber: Int) = Lotto(lottoResult).bonusNumberException(bonusNumber)

fun checkLotto(lottoResult: List<Int>, myLotto: List<List<Int>>, bonusNumber: Int): Array<Int> {
    val lotto = Lotto(lottoResult)
    val win = Array(6) { 0 }

    myLotto.forEach {
        val grade = lotto.checkLotto(it, bonusNumber)
        win[grade] += 1
    }

    return win
}