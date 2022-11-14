package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

lateinit var purchaseSum: String
var numOfLotto = 0
lateinit var selectedNum: Array<Int>
var myLottos = ArrayList<Array<Int>>()
lateinit var lottoWinNum: IntArray

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

fun printLottoNum() {
    println("%d개를 구매했습니다.".format(numOfLotto))
    for (i in 1..numOfLotto) {
        val lottos = pickLottoNum()
        println(java.util.Arrays.toString(lottos))
        myLottos.add(lottos)
    }
    println()
}

fun winNumInput() {
    println("당첨 번호를 입력해주세요.")
    lottoWinNum = Console.readLine().split(",").map { it.toInt() }.toIntArray()
    println()
}