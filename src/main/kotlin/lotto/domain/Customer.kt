package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.data.Message
import java.text.DecimalFormat

class Customer() {

    fun payMoney(): Int {
        val payment = Console.readLine()
        throwPaymentException(payment)
        return payment.toInt()

    }

    fun calculateIncome(money: Int, payment: Int): Double {
        val formattingNum = DecimalFormat("##00.0")
        return formattingNum.format(money.toDouble() / payment.toDouble() * 100).toDouble()
    }

    fun throwPaymentException(payment: String) {

        payment.forEach { char ->
            val charConvertedToCode = char.code
            if ((charConvertedToCode > 57) or (charConvertedToCode < 48)) {
                throw IllegalArgumentException("[ERROR] 정수만 입력 가능합니다")
            }
        }

        if ((payment.toInt() % 1000) != 0) throw IllegalArgumentException(Message.PAYMENT_RULE.message)
    }
}