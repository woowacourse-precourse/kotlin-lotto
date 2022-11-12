package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round

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
    var intersectionOfWinning = listOf<Int>()
    var intersectionOfBonus = listOf<Int>()
    for (i in 0 until numberOfPurchase) {
        val unionOfWinning = listOf(winningNumberList, purchasedNumberMap[i]).flatMap { it.orEmpty() }
        intersectionOfWinning = unionOfWinning
            .groupBy { it }
            .filter { it.value.size > 1 }
            .flatMap { it.value }
            .distinct()

        purchasedNumberMap[i]?.add(bonusNumber)
        intersectionOfBonus = purchasedNumberMap[i]!!
            .groupBy { it }
            .filter { it.value.size > 1 }
            .flatMap { it.value }
            .distinct()
    }
    var winningAmount = 0
    var three = 0
    var four = 0
    var five = 0
    var fiveWithBonus = 0
    var six = 0
    when (intersectionOfWinning.size) {
        3 -> {
            winningAmount += 5000
            three += 1
        }

        4 -> {
            winningAmount += 50000
            four += 1
        }

        5 -> {
            if (intersectionOfBonus.size != 1) {
                winningAmount += 1500000
                five += 1
            } else {
                winningAmount += 30000000
                fiveWithBonus += 1
            }
        }

        6 -> {
            winningAmount += 2000000000
            six += 1
        }
    }
    println(
        "3개 일치 (5,000원) - ${three}개\n" +
                "4개 일치 (50,000원) - ${four}개\n" +
                "5개 일치 (1,500,000원) - ${five}개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ${fiveWithBonus}개\n" +
                "6개 일치 (2,000,000,000원) - ${six}개"
    )
    val profit = (winningAmount.toDouble() / amountOfPurchase.toDouble()) * 100
    println("총 수익률은 ${round(profit * 10) / 10}%입니다.")
}
