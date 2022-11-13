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
}