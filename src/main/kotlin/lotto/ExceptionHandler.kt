package lotto

import camp.nextstep.edu.missionutils.Console
import org.junit.platform.commons.logging.LoggerFactory

object ExceptionHandler {

    private val log = LoggerFactory.getLogger(javaClass)
    fun checkAmount(amount: Int) {
        if (amount % 1000 != 0) {
            log.error() { "[ERROR] 1000으로 나누어 떨어지게 입력하세요" }
            throw IllegalArgumentException()
        }
    }

    fun checkNumber(): Int {
        try {
            return Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            log.error() { "[ERROR] 숫자만 입력하세요" }
            throw IllegalArgumentException()
        }
    }

    fun checkNumbers(): List<Int> {
        try {
            return Console.readLine()!!.split(",").map { it.toInt() }
        } catch (e: NumberFormatException) {
            log.error() { "[ERROR] 숫자만 입력하세요" }
            throw IllegalArgumentException()
        }
    }

    fun checkWinningNumber(winningNumber: List<Int>) {
        if (winningNumber.size != 6) {
            log.error() { "[ERROR] 6개를 입력하세요" }
            throw IllegalArgumentException()
        }
        if (winningNumber.size != winningNumber.toSet().size) {
            log.error() { "[ERROR] 중복된 수를 입력했습니다" }
            throw IllegalArgumentException()
        }
        repeat(winningNumber.size) {
            if (winningNumber[it] > 45 || winningNumber[it] < 1) {
                log.error() { "[ERROR] 1부터 45사이의 번호를 입력하세요" }
                throw IllegalArgumentException()
            }
        }
    }

    fun checkBonusNumber(bonusNumber: Int, winningNumber: List<Int>) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            log.error() { "[ERROR] 1부터 45사이의 번호를 입력하세요" }
            throw IllegalArgumentException()
        }
        repeat(winningNumber.size) {
            if (winningNumber.contains(bonusNumber)) {
                log.error() { "[ERROR] 당첨 번호와 중복됩니다" }
                throw IllegalArgumentException()
            }
        }
    }
}