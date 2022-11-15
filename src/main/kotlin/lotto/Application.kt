package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Lotto
import lotto.domain.MatchingCount
import lotto.domain.Shop

private val priceRegex = "\\d+".toRegex()
private val winningNumbersRegex = "[0-9]{1,2}(,[0-9]{1,2}){5}".toRegex()

fun main() {
    val price = inputPrice()

    val shop = Shop()
    val myLotto = shop.buyLotto(price)
    printMyLotto(myLotto)

    val winningNumbers = inputWinningNumbers()
    val bonusNumber = inputBonusNumber()

    val lotto = Lotto(winningNumbers)
    val matchingCount = lotto.getMatchingCount(bonusNumber, myLotto)
    printMatchingCount(matchingCount)

    val returnRate = lotto.getReturnRate(matchingCount, price)
    println("총 수익률은 ${String.format("%.1f", returnRate)}%입니다.")
}

fun inputPrice(): Int {
    println("구입금액을 입력해 주세요.")
    val price = Console.readLine()
    if(price.matches(priceRegex).not()) {
        println("[ERROR] 가격은 숫자여야만 한다.")
        throw NoSuchElementException("[ERROR] 가격은 숫자여야만 한다.")
    }

    require(price.toInt() % 1000 == 0) {
        "[ERROR] 구입금액은 1000으로 나누어 떨어져야한다."
    }

    return price.toInt()
}

fun printMyLotto(myLotto: List<List<Int>>) {
    println("${myLotto.size}개를 구매했습니다.")
    myLotto.forEach { numbers ->
        println(numbers.toString())
    }
}

fun inputWinningNumbers(): List<Int> {
    println("\n당첨번호를 입력해주세요.")
    val winningNumbers = Console.readLine()
    require(isValidWinningNumbers(winningNumbers)) {
        "[ERROR] 잘못된 로또 번호 형식을 입력하셨습니다."
    }

    return winningNumbers.split(',').map { it.toInt() }
}

fun inputBonusNumber(): Int {
    println("\n보너스 번호를 입력해 주세요.")
    val bonusNumber = Console.readLine().toInt()
    require(isValidBonusNumber(bonusNumber)) {
        "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    }

    return bonusNumber
}

fun printMatchingCount(matchingCount: MutableMap<MatchingCount, Int>) {
    println("\n당첨 통계")
    println("---")
    println("3개 일치 (5,000원) - ${matchingCount[MatchingCount.THREE]}개")
    println("4개 일치 (50,000원) - ${matchingCount[MatchingCount.FOUR]}개")
    println("5개 일치 (1,500,000원) - ${matchingCount[MatchingCount.FIVE]}개")
    println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${matchingCount[MatchingCount.FIVE_BONUS]}개")
    println("6개 일치 (2,000,000,000원) - ${matchingCount[MatchingCount.SIX]}개")
}

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