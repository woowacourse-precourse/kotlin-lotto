package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    try {
        lotto()
    } catch (e: IllegalArgumentException) {

    }
}

fun lotto() {
    val lottoCount = inputMoney()
    val winningNumber = inputWinningNumber()
    val bonusNumber = inputBonusNumber()
}

fun inputMoney(): Int {
    println("구입금액을 입력해 주세요.")
    val money = Console.readLine()
    checkMoneyThrowException(money)
    val lottoCount = money.toInt() / 1000
    println("${lottoCount}개를 구매했습니다.")
    return lottoCount
}

fun checkMoneyThrowException(userInput: String) {
    throwIsMoneyNumberException(userInput)
}

fun throwIsMoneyNumberException(userInput: String) {
    val numbers = userInput.toCharArray().filter { char ->
        char in '0'..'9'
    }
    if (numbers.size != userInput.length) {
        println("[ERROR] 구입 금액은 숫자여야 합니다.")
        throw IllegalArgumentException()
    }
}

fun inputWinningNumber(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    val userInput = Console.readLine()
    return userInput.split(',').map { it.toInt() }
}

fun inputBonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    val userInput = Console.readLine()
    return userInput.toInt()
}
