package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.AMOUNT_PURCHASE_MESSAGE
import lotto.ERROR_AMOUNT_NUMBER_MESSAGE

class User {
    fun inputUserAmount(): Int {
        println(AMOUNT_PURCHASE_MESSAGE)
        val userAmount = Console.readLine()

        checkAmount(userAmount)

        return userAmount.toInt()
    }

    fun checkAmount(userAmount: String) {
        if (!checkNumAmount(userAmount))
            throw IllegalArgumentException(ERROR_AMOUNT_NUMBER_MESSAGE)
    }

    private fun checkNumAmount(userAmount: String): Boolean =
        userAmount.count() == userAmount.replace("\\D".toRegex(), "").count()

}