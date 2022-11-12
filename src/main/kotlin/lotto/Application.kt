package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val inputVerifier = InputVerifier()
    val purchasedNumberMap = mutableMapOf<Int, MutableList<Int>>()

    println("구입금액을 입력해 주세요.")
    val amountOfPurchase = Console.readLine().toInt()
    inputVerifier.validateAmountOfPurchase(amountOfPurchase)

    val numberOfPurchase = amountOfPurchase.div(1000)
    println("${numberOfPurchase}개를 구매했습니다.")
    for (i in 0 until numberOfPurchase) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        purchasedNumberMap[i] = numbers.sorted().toMutableList()
        println(purchasedNumberMap[i])
    }

    println("당첨 번호를 입력해 주세요.")
    val winningNumber = Console.readLine()
    val winningNumberList = winningNumber.split(",").toList().map { it.toInt() }
    inputVerifier.validateWinningNumber(winningNumber)

    println("보너스 번호를 입력해 주세요.")
    val bonusNumber = Console.readLine().toInt()
    inputVerifier.validateBonusNumber(bonusNumber)

    println("당첨 통계")
    println("---")
    for (i in 0 until numberOfPurchase) {
        val unionOfWinning = listOf(winningNumberList, purchasedNumberMap[i]).flatMap { it.orEmpty() }
        val intersectionOfWinning = unionOfWinning
            .groupBy { it }
            .filter { it.value.size > 1 }
            .flatMap { it.value }
            .distinct()

        purchasedNumberMap[i]?.add(bonusNumber)
        val intersectionOfBonus = purchasedNumberMap[i]?.filter { item ->
            (purchasedNumberMap[i]?.count { it == item } ?: 0) > 1
        }?.distinct()
    }
}
