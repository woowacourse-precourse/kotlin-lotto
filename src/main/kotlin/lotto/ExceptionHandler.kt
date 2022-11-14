package lotto

import camp.nextstep.edu.missionutils.Console
import org.junit.platform.commons.logging.LoggerFactory

object ExceptionHandler {

    private val log = LoggerFactory.getLogger(javaClass)
    fun checkAmount(amount: Int) {
        if (amount % 1000 != 0) {
            log.error() { Error.DIVIDE.string }
            throw IllegalArgumentException()
        }
    }

    fun checkNumber(): Int {
        try {
            return Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            log.error() { Error.ONLY_NUMBER.string }
            throw IllegalArgumentException()
        }
    }

    fun checkNumbers(): List<Int> {
        try {
            return Console.readLine()!!.split(",").map { it.toInt() }
        } catch (e: NumberFormatException) {
            log.error() { Error.ONLY_NUMBER.string }
            throw IllegalArgumentException()
        }
    }

    fun checkBonusNumber(bonusNumber: Int, winningNumber: List<Int>) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            log.error() { Error.RANGE.string }
            throw IllegalArgumentException()
        }
        repeat(winningNumber.size) {
            if (winningNumber.contains(bonusNumber)) {
                log.error() { Error.OVERLAP.string }
                throw IllegalArgumentException()
            }
        }
    }
}