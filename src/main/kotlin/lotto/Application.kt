package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    val money = getMoney()
    println(money)
}

fun getMoney(): Int{
    println("구입금액을 입력해 주세요.")
    return Console.readLine().trim().toInt()
}
