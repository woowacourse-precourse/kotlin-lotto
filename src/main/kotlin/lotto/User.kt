package lotto

import camp.nextstep.edu.missionutils.Console
import util.InputException

class User {
    private val inputCheck = InputException()

    fun inputMoney(): Int {
        val input = Console.readLine()
        checkInputException(input)
        return input.toInt()
    }

    private fun checkInputException(input: String?) {
        inputCheck.checkTypeException(input)
        inputMoneyException(input!!)
    }

    private fun inputMoneyException(money: String) {
        if (money.toInt() % 1000 != 0) inputCheck.invalidException(VALUE_EXCEPTION)
    }

    companion object {
        const val VALUE_EXCEPTION = "잘못된 값입니다."
    }
}