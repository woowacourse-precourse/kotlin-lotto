package lotto

import camp.nextstep.edu.missionutils.Console

class User {
    fun inputMoney(): Int {
        val input = Console.readLine()
        checkTypeException(input)
        checkInputMoneyException(input.toInt())
        return input.toInt()
    }

    private fun checkInputMoneyException(money: Int) {

    }

    private fun checkTypeException(input: String?) {

    }
}