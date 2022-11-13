package lotto

import camp.nextstep.edu.missionutils.Randoms

private val winningNumbersRegex = "[0-9]{1,2}(,[0-9]{1,2}){5}".toRegex()

fun main() {

}

fun isValidPrice(price: Int): Boolean = (price % 1000 == 0)

fun isValidWinningNumbers(input: String): Boolean {
    if (input.matches(winningNumbersRegex).not()) {
        return false
    }

    val isErrorNumbers = input.split(',').any { it.toInt() !in 1..45 }
    if (isErrorNumbers) {
        return false
    }

    return true
}

fun isValidBonusNumber(number: Int): Boolean = (number in 1..45)

fun getRandomNumbers(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)
