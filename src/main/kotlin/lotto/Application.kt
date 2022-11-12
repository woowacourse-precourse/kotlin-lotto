package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
}

fun getPurchasePrice(): Int {
    println("구입금액을 입력해 주세요.")

    return Console.readLine().toInt()
}

fun getPrizeNumbers(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    return Console.readLine().split(",").map { it.toInt() }
}

fun getBonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    return Console.readLine().toInt()
}