package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.LOTTO_PURCHASE_MESSAGE

object LottoConsole {
    fun printPurchaseMessage() {
        println(LOTTO_PURCHASE_MESSAGE)
    }

    fun inputPurchaseAmount(): Int {
        val amount = Console.readLine()
        return amount.toInt()
    }
}