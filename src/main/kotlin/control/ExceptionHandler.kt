package control

import camp.nextstep.edu.missionutils.Console
import message.Error

object ExceptionHandler {
    fun checkAmount(amount: Int) {
        if (amount % 1000 != 0) {
            throw IllegalArgumentException(Error.DIVIDE.string)
        }
    }

    fun checkNumber(): Int {
        try {
            return Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(Error.ONLY_NUMBER.string)
        }
    }

    fun checkNumbers(): List<Int> {
        try {
            return Console.readLine()!!.split(",").map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(Error.ONLY_NUMBER.string)
        }
    }

    fun checkBonusNumber(bonusNumber: Int, winningNumber: List<Int>) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw IllegalArgumentException(Error.RANGE.string)
        }
        repeat(winningNumber.size) {
            if (winningNumber.contains(bonusNumber)) {
                throw IllegalArgumentException(Error.OVERLAP.string)
            }
        }
    }
}