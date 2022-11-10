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
    val number : List<String> = readLine()!!.split(",")
    val winNum: MutableList<Int> = ArrayList()
    for (element in number) {
        val numberToInt = element.toInt()
        if (winNum.contains(numberToInt)) throw IllegalArgumentException("[ERROR] 중복된 숫자를 입력하실 수 없습니다.")
        if (numberToInt !in 1..45) throw IllegalArgumentException("[ERROR] 1~45사이의 숫자만 입력하실 수 있습니다.")
        if (number.size != 6) throw IllegalArgumentException("[ERROR] 6가지의 수를 입력하십시오.")
        winNum.add(numberToInt)
    }
    Lotto(winNum).winNumber
}