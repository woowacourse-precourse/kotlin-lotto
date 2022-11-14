package lotto

import camp.nextstep.edu.missionutils.Console

class UserNumberPicker {
    private val _numbers = mutableListOf<Int>()
    val numbers get() = _numbers

    private var _bonusNumber = 0
    val bonusNumber get() = _bonusNumber

    fun userInput() {
        val input = Console.readLine().split(',')
        checkNumberType(input)
    }

    private fun checkNumberType(input: List<String>) {
        try {
            input.map { it.toInt() }
        } catch (e: Exception) {
            invalidInputValue(TYPE_ERROR)
        }
    }

    private fun checkNumberOverlap(input: List<String>) {
        if (input.size != input.toSet().size) invalidInputValue(VALUE_ERROR)
    }

    private fun checkNumberLength(input: List<String>) {
        if (input.size != 6) invalidInputValue(VALUE_ERROR)
    }

    private fun invalidInputValue(message: String) {
        throw IllegalArgumentException("[ERROR] : $message")
    }

    companion object {
        const val TYPE_ERROR = "숫자가 아닙니다."
        const val VALUE_ERROR = "올바른 값이 아닙니다."
    }

}