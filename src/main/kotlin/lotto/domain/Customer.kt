package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.data.Message
import java.text.DecimalFormat

class Customer() {

    fun payMoney(): Int {
        val payment = Console.readLine().toInt()
        throwPaymentException(payment)
        return payment
    }

    fun calculateIncome(money: Int, payment: Int): Double {
        val formattingNum = DecimalFormat("##00.0")
        return formattingNum.format(money.toDouble() / payment.toDouble() * 100).toDouble()
    }

    fun throwPaymentException(payment: Int) {
        if ((payment % 1000) != 0) throw IllegalArgumentException(Message.PAYMENT_RULE.message)
    }
}