package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

lateinit var purchaseSum: String
var numOfLotto = 0
lateinit var selectedNum: Array<Int>
var myLottos = ArrayList<Array<Int>>()
lateinit var lottoWinNum: IntArray
var bonusNum = 0

var threeWin = 0
var fourWin = 0
var fiveWin = 0
var fiveBonusWin = 0
var sixWin = 0

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

fun checkDigit(input: String): Boolean {
    var digitFlag = true
    for (s in input) {
        if (!s.isDigit()) digitFlag = false
    }
    return digitFlag
}

fun winNumInputCheck() {
    for (num in lottoWinNum) {
        if (num < 1 || num > 45 || !checkDigit(num.toString())) throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
}

fun bonusNumInput() {
    println("보너스 번호를 입력해주세요.")
    bonusNum = Console.readLine().toInt()
    println()
}

fun bonusNumInputCheck() {
    if (bonusNum < 1 || bonusNum > 45 || !checkDigit(bonusNum.toString())) {
        throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
    }
    if (lottoWinNum.contains(bonusNum)) {
        throw IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복돼서는 안됩니다.")
    }
}

fun printResult() {
    println("당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - %d개".format(threeWin))
    println("4개 일치 (50,000원) - %d개".format(fourWin))
    println("5개 일치 (1,500,000원) - %d개".format(fiveWin))
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개".format(fiveBonusWin))
    println("6개 일치 (2,000,000,000원) - %d개".format(sixWin))
}

fun printProfit() {
    val totalPrize =
        (threeWin * 5000) + (fourWin * 50000) + (fiveWin * 1500000) + (fiveBonusWin * 30000000) + (sixWin * 2000000000)
    val profit = (totalPrize.toFloat() / purchaseSum.toInt()) * 100
    print("총 수익률은 %.1f".format(profit))
    print("%입니다.")
}