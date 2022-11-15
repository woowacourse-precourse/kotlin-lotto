package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round


private var winNum: MutableList<Int> = ArrayList()
private var lottoBuyPrice : Int = 0
private var myLotto : Int = 0
private var newRandNumSet: MutableList<Int> = ArrayList()
private var allNewRandNumSet: MutableList<MutableList<Int>> = ArrayList()

fun main() {
    lottoPrice()
    winLottoNumber()
    bonusNumber()
}

fun lottoPrice(): Int {
    println("구입금액을 입력해 주세요.")
    lottoBuyPrice = readLine()!!.toInt()
    if (lottoBuyPrice % 1000 != 0) {
        throw IllegalArgumentException(ExceptionMessage.illegalErrorMessage)
    }
    if (lottoBuyPrice == 0) {
        throw IllegalArgumentException(ExceptionMessage.containErrorMessage)
    }
    myLotto = lottoBuyPrice / 1000
    myLottoCount(myLotto)
    return myLotto
}

fun randomNumber(): List<Int> {
    val random = Randoms.pickUniqueNumbersInRange(1, 45, 6).toList().sorted()
    newRandNumSet = random.toMutableList()
    allNewRandNumSet.add(newRandNumSet)
    return newRandNumSet
}

fun myLottoCount(lotto: Int) {
    println("\n${lotto}개를 구매했습니다.")
    randomNumList()
}

fun randomNumList() {
    for (i in 1..myLotto) {
        randomNumber()
        println(newRandNumSet)
    }
}

fun winLottoNumber() {
    println("\n당첨 번호를 입력해 주세요.")
    val number : List<String> = readLine()!!.split(",")
    for (element in number) {
        val numberToInt = element.toInt()
        if (winNum.contains(numberToInt)) throw IllegalArgumentException(ExceptionMessage.relateNumberMessage)
        if (numberToInt !in 1..45) throw IllegalArgumentException(ExceptionMessage.rangeErrorMessage)
        if (number.size != 6) throw IllegalArgumentException(ExceptionMessage.sizeErrorMessage)
        winNum.add(numberToInt)
    }
    Lotto(winNum).winNumber
}

fun bonusNumber() {
    println("\n보너스 번호를 입력해 주세요")
    val number = readLine()!!.toInt()
    if (number !in 1..45) {
        throw IllegalArgumentException(ExceptionMessage.rangeErrorMessage)
    }
    if (winNum.contains(number)) {
        throw IllegalArgumentException(ExceptionMessage.sameNumErrorMessage)
    }
    winStatistic(winNum, number)
}

fun winStatistic(win: MutableList<Int>, bonus: Int) {
    val countSet = mutableListOf(0, 0, 0, 0, 0)
    for (i in 0 until myLotto) {
        val equal = allNewRandNumSet[i].intersect(win.toSet())
        if (equal.size == 6) countSet[0]++
        if (equal.size == 5) {
            if (allNewRandNumSet[i].contains(bonus)) countSet[1]++
            else countSet[2]++
        }
        if (equal.size == 4) countSet[3]++
        if (equal.size == 3) countSet[4]++
    }
    winCount(countSet)
}

fun winCount(countSet: MutableList<Int>) {
    val result = (countSet[0] * 20000000000) + (countSet[1] * 30000000) + (countSet[2] * 1500000) + (countSet[3] * 50000) + (countSet[4] * 5000)
    val resultPerSent = String.format("%.1f", (result / lottoBuyPrice.toDouble() * 100)).toDouble()
    println("\n당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - ${countSet[4]}개")
    println("4개 일치 (50,000원) - ${countSet[3]}개")
    println("5개 일치 (1,500,000원) - ${countSet[2]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${countSet[1]}개")
    println("6개 일치 (2,000,000,000원) - ${countSet[0]}개")
    println("총 수익률은 ${resultPerSent}%입니다.")
}