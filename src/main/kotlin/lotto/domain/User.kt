package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.*

class User {

    fun inputUserPrizeNumber() {
        println(PRIZE_NUMBER_PURCHASE_MESSAGE)
        val prizeNumber = Console.readLine()

        checkPrizeNumber(prizeNumber)
    }

    fun checkPrizeNumber(prizeNumber: String) {
        val PrizeNumberGroup =changeCommaPrizeNumber(prizeNumber)
        
    }

    fun changeCommaPrizeNumber(prizeNumber: String) = prizeNumber.split(",")


    fun inputUserAmount(): Int {
        println(AMOUNT_PURCHASE_MESSAGE)
        val userAmount = Console.readLine()

        checkAmount(userAmount)

        return userAmount.toInt()
    }


    fun checkAmount(userAmount: String) {
        if (!checkNumAmount(userAmount))
            throw IllegalArgumentException(ERROR_AMOUNT_NUMBER_MESSAGE)
        if (checkBigNumAmount(userAmount) == null)
            throw IllegalArgumentException(ERROR_AMOUNT_BIG_NUMBER_MESSAGE)
        if (!checkDivideAmount(userAmount))
            throw IllegalArgumentException(ERROR_AMOUNT_DIVIDE_MESSAGE)
    }

    private fun checkNumAmount(userAmount: String): Boolean =
        userAmount.count() == userAmount.replace("\\D".toRegex(), "").count()

    private fun checkBigNumAmount(userAmount: String) = userAmount.toIntOrNull()
    private fun checkDivideAmount(userAmount: String): Boolean {
        if (userAmount.toInt() % 1000 != 0)
            return false
        return true
    }


}