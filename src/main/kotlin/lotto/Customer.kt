package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.data.InputErrorMessage

class Customer() {
    fun payMoney(): Int {
        val payment = Console.readLine().toInt()
        throwPaymentException(payment)
        return payment
    }

    fun throwPaymentException(payment: Int) {
        if ((payment % 1000) != 0) throw IllegalArgumentException(InputErrorMessage.PAYMENT_RULE.message)
    }
}