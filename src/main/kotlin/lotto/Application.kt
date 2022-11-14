package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import data.NumberRange
import data.Price
import lottery.Lottery

fun purchaseChecker(): Int {
    println("구입 금액을 입력해주세요.")
    val purchase = readLine().trim()
    try {
        if (purchase.toInt() % Price.STANDARD.price != 0)
            throw IllegalArgumentException("[ERROR] ${Price.STANDARD.price}원 단위로 입력하세요.")
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 숫자가 아닙니다.")
    }

    return purchase.toInt()
}

fun lotteryChecker(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    val input = readLine().trim().split(",")
    val lotteryNumbers = mutableListOf<Int>()
    input.forEach {
        if (it.toIntOrNull() == null)
            throw IllegalArgumentException("[ERROR] 숫자가 아닙니다.")
        lotteryNumbers.add(it.toInt())
    }

    return lotteryNumbers
}

fun bonusChecker(lotteryNumbers: List<Int>): Int {
    println("보너스 번호를 입력해 주세요.")
    val bonusNumber: Int
    try {
        bonusNumber = readLine().trim().toInt()
        if (lotteryNumbers.contains(bonusNumber))
            throw IllegalArgumentException("[ERROR] 중복된 숫자를 입력할 수 없습니다.")

        if (bonusNumber !in NumberRange.START.number..NumberRange.END.number) {
            throw IllegalArgumentException(
                "[ERROR] ${NumberRange.START.number}와 ${NumberRange.END.number} 사이 숫자를 입력하세요.")
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("[ERROR] 숫자가 아닙니다.")
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
