package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

enum class CORRECTCNT(val message: String) {
    THREE("3개 일치 (5,000원) - "),
    FOUR("4개 일치 (50,000원) - "),
    FIVE("5개 일치 (1,500,000원) - "),
    BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX("6개 일치 (2,000,000,000원) - ");
}

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
        printWin(win)
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
        val correct = lotto.checkLotto(it, bonusNumber)
        win[correct] += 1
    }

    return win
}

fun printWin(win: Array<Int>) {
    println("\n당첨 통계\n---")
    repeat(win.size - 1) {
        when(it) {
            0 -> print(CORRECTCNT.THREE.message)
            1 -> print(CORRECTCNT.FOUR.message)
            2 -> print(CORRECTCNT.FIVE.message)
            3 -> print(CORRECTCNT.BONUS.message)
            4 -> print(CORRECTCNT.SIX.message)
        }
        println("${win[it]}개")
    }
}