package lotto.view

import camp.nextstep.edu.missionutils.Console

fun inputPurchaseAmount(): Int? {
    println("구입금액을 입력해 주세요.")
    return inputInt()
}

fun inputLottoWinningNumbers(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    return input().split(',').map { it.toInt() }
}

fun inputBonusNumbers(): Int? {
    println("보너스 번호를 입력해 주세요.")
    return inputInt()
}

private fun inputInt() = Console.readLine().toIntOrNull()

private fun input() = Console.readLine()
