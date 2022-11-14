package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.*
import java.lang.IllegalArgumentException

lateinit var user: User
lateinit var lottoNums: List<Lotto>
lateinit var lottoWinNums: LottoWinNums
val winCase = MutableList(5) { 0 }
var earningMoney = 0L

fun inputPurchasingAmount(): Int {
    println(INPUT_PURCHASE_AMOUNT_MSG)
    try {
        user = User(Console.readLine())
    } catch (e: IllegalArgumentException) {
        return -1
    }

    return 0
}

fun makeLottoWinNumbers(): Int {
    try {
        lottoNums = List(user.numOfLotto) { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)) }
    } catch (e: IllegalArgumentException) {
        return -1
    }

    return 0
}

fun inputWinNumbers(): Int {
    println(INPUT_WIN_NUM_MSG)
    val winNums = Console.readLine().split(",").map { it.toInt() }
    println(INPUT_BONUS_NUM_MSG)
    val bonusNum = Console.readLine().toInt()

    try {
        lottoWinNums = LottoWinNums(winNums, bonusNum)
    } catch (e: IllegalArgumentException) {
        return -1
    }

    return 0
}

fun printLottoWinNumbers() {
    println(user.numOfLotto.toString() + NUM_OF_LOTTO_MSG)
    for (case in lottoNums) case.printLottoWinNum()
}

fun printResult() {
    println(WIN_RESULT_MSG)
    for (i in 0 until 5) {
        println(LottoWinCaseString.getMsg(i) + winCase[i] + "개")
    }
    println(earningRateMSG((earningMoney.toDouble() / user.purchaseMoney) * 100))

}

fun calcResult() {
    for (case in lottoNums) {
        val caseNum = case.calcWin(lottoWinNums)

        if (caseNum < 0) {
            continue
        }

        winCase[caseNum]++
        earningMoney += LottoWinCaseMoney.getPrizeMoney(caseNum)
    }
}

fun main() {
    if (inputPurchasingAmount() == -1) return
    if (makeLottoWinNumbers() == -1) return
    printLottoWinNumbers()
    if (inputWinNumbers() == -1) return
    calcResult()
    printResult()
}