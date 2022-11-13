package lotto.views

import lotto.constants.Constant
import lotto.constants.Message

object OutputView {
    fun printInputMoney() {
        println(Message.MESSAGE_INPUT_MONEY)
    }

    fun printAmount(amount: Int) {
        println("$amount" + Message.MESSAGE_PRINT_AMOUNT)
    }
}