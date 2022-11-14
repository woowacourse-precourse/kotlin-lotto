package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.toIntOrError
import lotto.resources.INPUT_BONUS_NUMBER
import lotto.resources.INPUT_PURCHASE_AMOUNT
import lotto.resources.INPUT_WINNING_NUMBERS

fun inputPurchaseAmount(): Int {
    println(INPUT_PURCHASE_AMOUNT)
    return inputInt()
}

fun inputLottoWinningNumbers(): String {
    println(INPUT_WINNING_NUMBERS)
    return input()
}

fun inputBonusNumber(): Int {
    println(INPUT_BONUS_NUMBER)
    return inputInt()
}

private fun inputInt() = Console.readLine().toIntOrNull().toIntOrError()

private fun input() = Console.readLine()
