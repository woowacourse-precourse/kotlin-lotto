package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.*

class User {
    fun inputUserBonusNumber(userGamePrizeNumber: Lotto): Int {
        println(BONUS_NUMBER_MESSAGE)
        val bonusNumber = Console.readLine()

        checkBonusNumber(bonusNumber, userGamePrizeNumber)
        return bonusNumber.toInt()
    }

    fun checkBonusNumber(bonusNumber: String, userGamePrizeNumber: Lotto) {
        if (!checkNumber(bonusNumber) || bonusNumber == "")
            throw IllegalArgumentException(ERROR_PRIZE_NUMBER_MESSAGE)
        if (checkRangeBonusNumber(bonusNumber))
            throw IllegalArgumentException(ERROR_BONUS_NUMBER_MESSAGE)
        if (checkRepeatBonusNumber(bonusNumber, userGamePrizeNumber) != null)
            throw IllegalArgumentException(ERROR_BONUS_REPEAT_MESSAGE)
    }

    private fun checkRepeatBonusNumber(bonusNumber: String, userGamePrizeNumber: Lotto): Int? {
        return userGamePrizeNumber.getNumbers().find {
            it == bonusNumber.toInt()
        }
    }


    private fun checkRangeBonusNumber(bonusNumber: String) = bonusNumber.toInt() < 1 || bonusNumber.toInt() > 45

    fun inputUserPrizeNumber(): Lotto {
        println(PRIZE_NUMBER_PURCHASE_MESSAGE)
        val prizeNumber = Console.readLine()

        return checkPrizeNumber(prizeNumber)
    }


    fun checkPrizeNumber(prizeNumber: String): Lotto {
        val prizeNumberGroup = changeCommaPrizeNumber(prizeNumber)
        if (!checkNumPrizeGroup(prizeNumberGroup))
            throw IllegalArgumentException(ERROR_PRIZE_NUMBER_MESSAGE)
        if (!checkRangePrizeGroup(prizeNumberGroup))
            throw IllegalArgumentException(ERROR_PRIZE_RANGE_MESSAGE)
        return Lotto(prizeNumberGroup.map { it.toInt() })
    }

    private fun checkRangePrizeGroup(prizeNumberGroup: List<String>): Boolean {
        for (i in prizeNumberGroup) {
            if (i.toInt() < 1 || i.toInt() > 45)
                return false
        }
        return true
    }

    private fun checkNumPrizeGroup(prizeNumberGroup: List<String>): Boolean {
        for (i in prizeNumberGroup) {
            if (!checkNumber(i))
                return false
        }
        return true
    }

    private fun changeCommaPrizeNumber(prizeNumber: String) = prizeNumber.split(",")


    fun inputUserAmount(): Int {
        println(AMOUNT_PURCHASE_MESSAGE)
        val userAmount = Console.readLine()

        checkAmount(userAmount)

        return userAmount.toInt()
    }


    fun checkAmount(userAmount: String) {
        if (!checkNumber(userAmount) || userAmount == "")
            throw IllegalArgumentException(ERROR_AMOUNT_NUMBER_MESSAGE)
        if (checkBigNum(userAmount) == null)
            throw IllegalArgumentException(ERROR_BIG_NUMBER_MESSAGE)
        if (!checkDivideAmount(userAmount))
            throw IllegalArgumentException(ERROR_AMOUNT_DIVIDE_MESSAGE)
    }

    private fun checkNumber(userAmount: String): Boolean =
        userAmount.count() == userAmount.replace("\\D".toRegex(), "").count()

    private fun checkBigNum(userAmount: String) = userAmount.toIntOrNull()
    private fun checkDivideAmount(userAmount: String): Boolean {
        if (userAmount.toInt() % 1000 != 0 || userAmount.toInt() == 0)
            return false
        return true
    }


}