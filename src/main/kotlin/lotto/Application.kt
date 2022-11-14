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

    val myLotto = getLotto(price)
    println("\n${myLotto.size}개를 구매했습니다.")
    myLotto.forEach { numbers ->
        println(numbers.toString())
    }

    println("\n당첨번호를 입력해주세요.")
    val winningNumbers = Console.readLine()
    if (isValidWinningNumbers(winningNumbers).not()) {
        throw IllegalArgumentException("[ERROR]")
    }
    val numbers = winningNumbers.split(',').map { it.toInt() }

    println("\n보너스 번호를 입력해 주세요.")
    val bonusNumber = Console.readLine().toInt()
    if (isValidBonusNumber(bonusNumber).not()) {
        throw IllegalArgumentException("[ERROR]")
    }

    val lotto = Lotto(numbers)
    var threeCount = 0
    var fourCount = 0
    var fiveCount = 0
    var fiveBonusCount = 0
    var sixCount = 0
    myLotto.forEach {
        when (lotto.getMatchingNumberCount(it, bonusNumber)) {
            LottoMatchingCount.THREE -> threeCount += 1
            LottoMatchingCount.FOUR -> fourCount += 1
            LottoMatchingCount.FIVE -> fiveCount += 1
            LottoMatchingCount.FIVE_BONUS -> fiveBonusCount += 1
            LottoMatchingCount.SIX -> sixCount += 1
            LottoMatchingCount.ETC -> Unit
        }
    }

    println("\n당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - ${threeCount}개")
    println("4개 일치 (50,000원) - ${fourCount}개")
    println("5개 일치 (1,500,000원) - ${fiveCount}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${fiveBonusCount}개")
    println("6개 일치 (2,000,000,000원) - ${sixCount}개")
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

fun getRandomNumbers(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()

fun getLotto(price: Int): List<List<Int>> {
    val lotto = mutableListOf<List<Int>>()
    repeat(price / 1000) {
        lotto.add(getRandomNumbers())
    }

    return lotto.toList()
}