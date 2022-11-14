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

fun bonusChecker(): Int {
    println(StringResource.BONUS.resource)
    val bonusNumber: Int
    try {
        bonusNumber = readLine().trim().toInt()
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

fun rangeChecker(bonusNumber: Int, lotteryNumber: List<Int>): Boolean {
    if (bonusNumber in lotteryNumber) {
        println(StringResource.DUPLICATE.resource)
        return true
    }

    return false
}

fun inputChecker(): Triple<Int, List<Int>, Int> {
    val purchase = purchaseChecker()
    if (purchase == -1) {
        return Triple(-1, listOf(), -1)
    }
    val lotteryNumbers = lotteryChecker()
    if (lotteryNumbers.isEmpty()) {
        return Triple(-1, listOf(), -1)
    }
    val bonusNumber = bonusChecker()
    if (bonusNumber == -1) {
        return Triple(-1, listOf(), -1)
    }

    return Triple(purchase, lotteryNumbers, bonusNumber)
}

fun main() {
    val (purchase, lotteryNumbers, bonusNumber) = inputChecker()
    if (purchase == -1 && lotteryNumbers.isEmpty() && bonusNumber == -1) {
        return
    }
    if (rangeChecker(bonusNumber, lotteryNumbers)) {
        return
    }

    val lotto = Lottery(purchase, Lotto(lotteryNumbers), bonusNumber)

    lotto.printQuickPick()
    lotto.printWinnings()
    lotto.printIncomeRatio()

}
