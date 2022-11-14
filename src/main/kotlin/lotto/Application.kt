package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

lateinit var purchaseSum: String
var numOfLotto = 0
lateinit var selectedNum: Array<Int>

fun main() {

}

fun costInput() {
    println("구입 금액을 입력해주세요.")
    purchaseSum = Console.readLine()
}

fun checkCostInput() {
    try {
        numOfLotto = purchaseSum.toInt() / 1000
        println()
    } catch (e: IllegalArgumentException) {
        println("[ERROR] 금액을 천원 단위의 숫자로 입력해주세요.")
    }
    if (purchaseSum.toInt() % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 금액을 천원 단위의 숫자로 입력해주세요.")
    }
}

fun pickLottoNum(): Array<Int> {
    selectedNum = Randoms.pickUniqueNumbersInRange(1, 45, 6).toTypedArray()
    selectedNum.sort()

    return selectedNum
}