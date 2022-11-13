package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import data.NumberRange
import data.Price
import lottery.Lottery

fun purchaseChecker(input: String): Boolean {
    try {
        if (input.toInt() % Price.STANDARD.price != 0) {
            println("[ERROR] ${Price.STANDARD.price}원 단위로 입력하세요.")
            return false
        }

    } catch (e: NumberFormatException) {
        println("[ERROR] 숫자가 아닙니다.")
        return false
    }
    return true
}

fun lotteryChecker(input: String): Boolean {
    val splitInput = input.split(",")
    splitInput.forEach {
        if (it.toIntOrNull() == null) {
            println("[ERROR] 숫자가 아닙니다.")
            return false
        }
    }

    return true
}

fun bonusChecker(input: String, lotteryNumbers: String): Boolean {
    try {
        if (lotteryNumbers.split(",").contains(input)) {
            println("[ERROR] 중복된 숫자를 입력할 수 없습니다.")
            return false
        }
        val bonusNumber = input.toInt()
        if (bonusNumber !in NumberRange.START.number..NumberRange.END.number) {
            println("[ERROR] ${NumberRange.START.number}와 ${NumberRange.END.number} 사이 숫자를 입력하세요.")
            return false
        }
    } catch (e: NumberFormatException) {
        println("[ERROR] 숫자가 아닙니다.")
        return false
    }
    return true
}

fun main() {
    val lotto = Lottery()

    println("구입 금액을 입력해주세요.")
    val purchase = readLine().trim()
    if (!purchaseChecker(purchase))
        return
    lotto.printQuickPick(purchase)

    println("당첨 번호를 입력해 주세요.")
    val lotteryNumbers = readLine().trim()
    if (!lotteryChecker(lotteryNumbers))
        return
    lotto.getLotteryNumbers(lotteryNumbers)

    println("보너스 번호를 입력해 주세요.")
    val bonusNumber = readLine().trim()
    if (!bonusChecker(bonusNumber, lotteryNumbers))
        return
    lotto.getBonusNumber(bonusNumber)

    lotto.printWinnings()
    lotto.printIncomeRatio()

}
