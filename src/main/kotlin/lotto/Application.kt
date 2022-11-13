package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

private val winningNumbersRegex = "[0-9]{1,2}(,[0-9]{1,2}){5}".toRegex()

fun main() {
    println("구입금액을 입력해 주세요.")
    val price = Console.readLine().toInt()
    if (isValidPrice(price).not()) {
        throw IllegalArgumentException("[ERROR]")
    }

    val lotto = getLotto(price)
    println("\n${lotto.size}개를 구매했습니다.")
    lotto.forEach { numbers ->
        println(numbers.toString())
    }
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

fun getLotto(price: Int): List<List<Int>> {
    val lotto = mutableListOf<List<Int>>()
    repeat(price / 1000) {
        lotto.add(getRandomNumbers())
    }

    return lotto.toList()
}