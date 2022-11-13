package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    val money = getMoney()
    println(money)
}

fun getMoney(): Int{
    return Console.readLine().trim().toInt()
}
