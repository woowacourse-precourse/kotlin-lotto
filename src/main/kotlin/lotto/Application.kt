package lotto

import camp.nextstep.edu.missionutils.Console

const val userInputMsg = "구입금액을 입력해 주세요."
fun main() {
    getUserInputPrice()
}
private fun getUserInputPrice() {
    println(userInputMsg)
    val userInput = Console.readLine()
}