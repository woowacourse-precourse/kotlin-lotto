package lotto

import camp.nextstep.edu.missionutils.Randoms


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
        throw IllegalArgumentException("[ERROR] 잘못된 값을 입력하였습니다.")
    }
    if (lottoBuyPrice == 0) {
        throw IllegalArgumentException("[ERROR] 로또는 한 장 이상 사야합니다.")
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
        if (winNum.contains(numberToInt)) throw IllegalArgumentException("[ERROR] 중복된 숫자를 입력하실 수 없습니다.")
        if (numberToInt !in 1..45) throw IllegalArgumentException("[ERROR] 1~45사이의 숫자만 입력하실 수 있습니다.")
        if (number.size != 6) throw IllegalArgumentException("[ERROR] 6가지의 수를 입력하십시오.")
        winNum.add(numberToInt)
    }
    Lotto(winNum).winNumber
}

fun bonusNumber() {
    println("\n보너스 번호를 입력해 주세요")
    val number = readLine()!!.toInt()
    if (number !in 1..45) {
        throw IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력하실 수 있습니다.")
    }
    if (winNum.contains(number)) {
        throw IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 일치할 수 업습니다.")
    }
    winStatistic(winNum, number)
}

fun winStatistic(win: MutableList<Int>, bonus: Int) {
    val countSet = mutableListOf(0, 0, 0, 0, 0)
    for (i in 0 until myLotto) {
        val equal = allNewRandNumSet[i].intersect(win.toSet())
        if (equal.size == 6) countSet[0]++
        if (equal.size == 5 && allNewRandNumSet[i].contains(bonus)) countSet[1]++
        else if (equal.size == 5) countSet[2]++
        if (equal.size == 4) countSet[3]++
        if (equal.size == 3) countSet[4]++
    }
    winCount(countSet)
}

fun winCount(countSet: MutableList<Int>) {
    println("\n당첨 통계\n")
    println("3개 일치 (5,000원) - ${countSet[4]}개")
    println("4개 일치 (50,000원) - ${countSet[3]}개")
    println("5개 일치 (1,500,000원) - ${countSet[2]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${countSet[1]}개")
    println("6개 일치 (2,000,000,000원) - ${countSet[0]}개")
}