package lotto.presentation

import camp.nextstep.edu.missionutils.Console
import lotto.LOTTO_PURCHASE_MESSAGE
import lotto.domain.LottoExceptionHandler.validateIntType

object LottoConsole {
    fun printPurchaseMessage() {
        println(LOTTO_PURCHASE_MESSAGE)
    }

    fun inputPurchaseAmount(): Int {
        val amount = Console.readLine()
        validatePurchaseAmount(amount)

        return amount.toInt()
    }

    private fun validatePurchaseAmount(amount: String) {
        validateIntType(amount)
    }
}