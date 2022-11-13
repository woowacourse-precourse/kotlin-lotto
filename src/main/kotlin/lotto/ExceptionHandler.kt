package lotto

import camp.nextstep.edu.missionutils.Console

object ExceptionHandler {
    fun checkAmount(amount: Int) {
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지게 입력하세요")
        }
    }

    fun checkNumber(): Int {
        try {
            return Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 숫자만 입력하세요")
        }
    }

    fun checkNumbers(): List<Int> {
        try {
            return Console.readLine()!!.split(",").map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 숫자만 입력하세요")
        }
    }

    fun checkWinningNumber(winningNumber: List<Int>) {
        if (winningNumber.size != 6) {
            throw IllegalArgumentException("[ERROR] 6개를 입력하세요")
        }
        if (winningNumber.size != winningNumber.toSet().size) {
            throw IllegalArgumentException("[ERROR] 중복된 수를 입력했습니다")
        }
        repeat(winningNumber.size) {
            if (winningNumber[it] > 45 || winningNumber[it] < 1) {
                throw IllegalArgumentException("[ERROR] 1부터 45사이의 번호를 입력하세요")
            }
        }
    }
}