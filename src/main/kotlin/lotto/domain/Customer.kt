package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.data.Message

class Customer() {

    fun payMoney(): Int {
        val payment = Console.readLine().toInt()
        throwPaymentException(payment)
        return payment
    }

    fun calculateIncome(money: Int, payment: Int): Float {
        return money.toFloat() / payment.toFloat() * 100
    }

    fun throwPaymentException(payment: Int) {
        if ((payment % 1000) != 0) throw IllegalArgumentException(Message.PAYMENT_RULE.message)
    }
}