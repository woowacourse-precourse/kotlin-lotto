package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printHowManyLottoBuy(2000)
}

fun printHowManyLottoBuy(money: Int) {
    var result: Int = money / 1000
    println("${result}개를 구매했습니다.")

}