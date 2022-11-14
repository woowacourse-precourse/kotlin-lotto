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
    val lottoCount = generateLottoCount()
    val winningNumber = generateWinningNumbers()
    val bonusNumber = inputBonusNumber()
}

fun generateLottoCount(): Int {
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
    val numbers = userInput.toCharArray().filter { number ->
        number in '0'..'9'
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

fun generateWinningNumbers(): Lotto {
    println("당첨 번호를 입력해 주세요.")
    val userInput = Console.readLine()
    val winningNumbers = convertWinningNumbersStringToIntList(userInput)
    return Lotto(winningNumbers)
}

fun convertWinningNumbersStringToIntList(userInput: String): List<Int> {
    throwWinningNumberFormException(userInput)
    return userInput.split(',').map { it.toInt() }
}

fun throwWinningNumberFormException(userInput: String) {
    userInput.forEach { char ->
        if (!(char in '0'..'9' || char == ',')) {
            println("[ERROR] 로또 번호는 숫자와 ,만 입력 해야 합니다.")
            throw IllegalArgumentException()
        }
    }
}

fun inputBonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    val userInput = Console.readLine()
    return userInput.toInt()
}
