package lotto.view

import camp.nextstep.edu.missionutils.Console

fun inputPurchaseAmount(): Int? {
    println("구입금액을 입력해 주세요.")
    return inputInt()
}

private fun inputInt() = Console.readLine().toIntOrNull()
