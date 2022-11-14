package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import data.NumberRange
import data.Price
import data.StringResource
import lottery.Lottery

fun purchaseChecker(): Int {
    println(StringResource.PURCHASE.resource)
    val purchase = readLine().trim()
    try {
        if (purchase.toInt() % Price.STANDARD.price != 0) {
            println(StringResource.REMAINDER.resource)
            return -1
        }
    } catch (e: NumberFormatException) {
        println(StringResource.NUMBERERROR.resource)
        return -1
    }

    return purchase.toInt()
}

fun lotteryChecker(): List<Int> {
    println(StringResource.LOTTO.resource)
    val input = readLine().trim().split(",")
    val lotteryNumbers = mutableListOf<Int>()
    input.forEach {
        if (it.toIntOrNull() == null) {
            println(StringResource.NUMBERERROR.resource)
            return listOf()
        }
        lotteryNumbers.add(it.toInt())
    }

    return lotteryNumbers
}

fun bonusChecker(lotteryNumbers: List<Int>): Int {
    println(StringResource.BONUS.resource)
    val bonusNumber: Int
    try {
        bonusNumber = readLine().trim().toInt()
        if (lotteryNumbers.contains(bonusNumber)) {
            println(StringResource.DUPLICATE.resource)
            return -1
        }
        if (bonusNumber !in NumberRange.START.number..NumberRange.END.number) {
            println(StringResource.RANGEERROR.resource)
            return -1
        }
    } catch (e: NumberFormatException) {
        println(StringResource.NUMBERERROR.resource)
        return -1
    }
    return bonusNumber
}

fun main() {
    val purchase = purchaseChecker()
    if (purchase == -1) return
    val lotteryNumbers = lotteryChecker()
    if (lotteryNumbers.isEmpty()) return
    val bonusNumber = bonusChecker(lotteryNumbers)
    if (bonusNumber == -1) return
    val lotto = Lottery(purchase, Lotto(lotteryNumbers), bonusNumber)

    lotto.printQuickPick()
    lotto.printWinnings()
    lotto.printIncomeRatio()

}
