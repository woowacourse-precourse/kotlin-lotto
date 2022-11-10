package lotto

import camp.nextstep.edu.missionutils.Randoms


fun main() {
    lottoPrice()
    winLottoNumber()
}

fun lottoPrice() {
    println("구입금액을 입력해 주세요.")
    val lottoBuyPrice = readLine()!!.toInt()
    if (lottoBuyPrice % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] 잘못된 값을 입력하였습니다.")
    }
    if (lottoBuyPrice == 0) {
        throw IllegalArgumentException("[ERROR] 로또는 한 장 이상 사야합니다.")
    }
    val myLotto = lottoBuyPrice / 1000
    myLotto(myLotto)
}

fun randomNumber(): List<Int> {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6).toList().sorted()
}

fun myLotto(lotto: Int) {
    println("\n${lotto}개를 구매했습니다.")
    for (i in 1..lotto) {
        randomNumber()
        println(randomNumber())
    }
}

fun winLottoNumber() {
    println("\n당첨 번호를 입력해 주세요.")
    val number = readLine()!!.split(",")
    val winNum: MutableList<Int> = ArrayList()
    for (i in 0..5) {
        winNum.add(number[i].toInt())
    }
    Lotto(winNum).winNumber
}