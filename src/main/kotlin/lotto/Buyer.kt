package lotto

import java.lang.IllegalArgumentException

class Buyer {
    fun enterAmount(): Int {
        val input = readln()
        checkIsInIntRange(input)
        return input.toInt()
    }

    private fun checkIsInIntRange(input: String) {
        if (input.toLong() > Int.MAX_VALUE) {
            println("[ERROR] 구매 가능 최대 금액은 2147483000원입니다.")
            throw IllegalArgumentException("구매 가능 최대 금액은 2147483000원입니다.")
        }
    }
}