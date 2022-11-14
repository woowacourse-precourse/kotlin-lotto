package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    lotto()
}

fun lotto() {
    val lottoCount = inputMoney()
    val winningNumber = inputWinningNumber()
}

fun inputMoney(): Int {
    println("구입금액을 입력해 주세요.")
    val money = Console.readLine()
    val lottoCount = money.toInt() / 1000
    println("${lottoCount}개를 구매했습니다.")
    return lottoCount
}

fun inputWinningNumber(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    val userInput = Console.readLine()
    return userInput.split(',').map { it.toInt() }
}
