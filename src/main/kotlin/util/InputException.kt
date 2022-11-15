package util

import lotto.User

class InputException {
    fun checkTypeException(input: String?) {
        try {
            input?.toInt()
        } catch (e: Exception) {
            invalidException(TYPE_EXCEPTION)
        }
    }

    fun checkTypeException(input: List<String>) {
        try {
            input.map { it.toInt() }
        } catch (e: Exception) {
            invalidException(TYPE_EXCEPTION)
        }
    }

    fun checkNullException(input: String?) {
        if (input.isNullOrEmpty()) {
            invalidException(NULL_EXCEPTION)
        }
    }

    fun inputMoneyException(money: String) {
        if (money.toInt() % 1000 != 0) invalidException(VALUE_EXCEPTION)
    }

    fun checkRangeException(numbers: List<Int>) {
        numbers.forEach { num ->
            if (num !in 1..45) invalidException(VALUE_EXCEPTION)
        }
    }

    private fun invalidException(message: String) {
        throw IllegalArgumentException("[ERROR] : $message")
    }

    companion object {
        const val TYPE_EXCEPTION = "올바른 형식이 아닙니다."
        const val NULL_EXCEPTION = "아무 것도 입력하지 않았습니다."
        const val VALUE_EXCEPTION = "잘못된 값입니다."
    }
}