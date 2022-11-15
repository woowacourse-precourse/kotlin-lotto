package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.constants.*
import java.lang.IllegalArgumentException
import kotlin.math.round

lateinit var user: User
lateinit var lottoWinNums: LottoWinNums

fun inputPurchasingAmount(): Int {
    println(INPUT_PURCHASE_AMOUNT_MSG)
    try {
        user = User(Console.readLine())
    } catch (e: IllegalArgumentException) {
        return -1
    }

    return 0
}

fun makeLottoNumbers(): Int {
    try {
        user.makeLottoNum()
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

fun printLottoNumbers() {
    println(user.numOfLotto.toString() + NUM_OF_LOTTO_MSG)
    user.printLottoNum()
}

fun calcEarningRate(earningMoney:Long,purchaseMoney:Long):Double{
    return round((earningMoney.toDouble()/purchaseMoney) *1000)/10
}
fun printResult() {
    println(WIN_RESULT_MSG)
    for (i in 0 until 5) {
        println(LottoWinCaseMsg.getMsg(i) + user.winCase[i] + "개")
    }
    println(earningRateMSG(calcEarningRate(user.earningMoney , user.purchaseMoney)))

}


fun main() {
    if (inputPurchasingAmount() == -1) return
    if (makeLottoNumbers() == -1) return
    printLottoNumbers()
    if (inputWinNumbers() == -1) return
    user.calcResult()
    printResult()
}