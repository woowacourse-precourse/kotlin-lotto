package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.AMOUNT_PURCHASE_MESSAGE

class User {
    fun inputUserAmount(): Int {
        println(AMOUNT_PURCHASE_MESSAGE)
        val userAmount = Console.readLine()

        return userAmount.toInt()
    }
}