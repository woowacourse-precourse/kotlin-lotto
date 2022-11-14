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
    throwMoneyUnitException(userInput)
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

fun throwMoneyUnitException(userInput: String) {
    if (userInput.toInt() % 1000 != 0) {
        println("[ERROR] 구입 금액은 1,000원 단위여야 합니다.")
        throw IllegalArgumentException()
    }
}

fun inputWinningNumber(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    val userInput = Console.readLine()
    checkWinningNumberThrowException(userInput)
    return userInput.split(',').map { it.toInt() }
}

fun checkWinningNumberThrowException(userInput: String) {
    throwLottoSizeException(userInput)
    throwLottoNumberRangeException(userInput)
}

fun throwLottoSizeException(userInput: String) {
    val numbers = userInput.split(',').map { it.toInt() }
    if (numbers.size != 6) {
        println("[ERROR] 로또 번호는 6개의 숫자여야 합니다.")
        throw IllegalArgumentException()
    }
}

fun throwLottoNumberRangeException(userInput: String) {
    val numbers = userInput.split(',').map { it.toInt() }
    for (number in numbers) {
        if(number !in 1..45) {
            println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            throw IllegalArgumentException()
        }
    }
}

fun inputBonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    val userInput = Console.readLine()
    return userInput.toInt()
}
