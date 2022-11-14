package lotto

import camp.nextstep.edu.missionutils.Console

class UserNumberPicker {
    private val _numbers = mutableListOf<Int>()
    val numbers get() = _numbers

    private var _bonusNumber = 0
    val bonusNumber get() = _bonusNumber

    fun userNumbersInput() {
        val input = Console.readLine().split(',')
        checkNumberException(input)
        _numbers.addAll(input.map { it.toInt() })
    }

    fun userBonusInput() {
        val input = Console.readLine()
        checkBonusException(input)
    }

    private fun checkBonusException(input: String) {
        checkBonusType(input)
        checkBonusOverlap(input.toInt())
        checkBonusRange(input.toInt())
    }

    private fun checkBonusRange(bonus: Int) {
        if (bonus !in 1..45) invalidInputValue(VALUE_ERROR)
    }

    private fun checkBonusOverlap(bonus: Int) {
        if (_numbers.contains(bonus)) invalidInputValue(VALUE_ERROR)
    }

    private fun checkNumberException(input: List<String>) {
        checkNumberType(input)
        checkNumberOverlap(input)
        checkNumberLength(input)
    }

    private fun checkBonusType(input: String) {
        try {
            input.toInt()
        } catch (e: Exception) {
            invalidInputValue(TYPE_ERROR)
        }
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

    fun printNoticeNumbers() = println("당첨 번호를 입력해 주세요.")

    fun printNoticeBonusNumber() = println("보너스 번호를 입력해 주세요.")

    companion object {
        const val TYPE_ERROR = "숫자가 아닙니다."
        const val VALUE_ERROR = "올바른 값이 아닙니다."
    }

}