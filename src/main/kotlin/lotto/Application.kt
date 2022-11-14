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
            throw IllegalArgumentException(StringResource.REMAINDER.resource)
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(StringResource.NUMBERERROR.resource)
    }

    return purchase.toInt()
}

fun lotteryChecker(): List<Int> {
    println(StringResource.LOTTO.resource)
    val input = readLine().trim().split(",")
    val lotteryNumbers = mutableListOf<Int>()
    input.forEach {
        if (it.toIntOrNull() == null)
            throw IllegalArgumentException(StringResource.NUMBERERROR.resource)
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
            throw IllegalArgumentException(StringResource.DUPLICATE.resource)
        }
        if (bonusNumber !in NumberRange.START.number..NumberRange.END.number) {
            throw IllegalArgumentException(StringResource.RANGEERROR.resource)
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(StringResource.NUMBERERROR.resource)
    }
    return bonusNumber
}

fun main() {
    val purchase = purchaseChecker()
    val lotteryNumbers = lotteryChecker()
    val bonusNumber = bonusChecker(lotteryNumbers)
    val lotto = Lottery(purchase, Lotto(lotteryNumbers), bonusNumber)

    lotto.printQuickPick()
    lotto.printWinnings()
    lotto.printIncomeRatio()

}
