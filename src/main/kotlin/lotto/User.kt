package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.exception.InputException

class User {
    private val inputCheck = InputException()

    private var _inputMoney = 0
    val inputMoney get() = _inputMoney

    fun inputMoney() {
        val input = userInput()
        try {
            inputCheck.checkInputException(input)
            _inputMoney = input.toInt()
        } catch (e: Exception) {
        }
    }

    fun getLottos() = _inputMoney / 1000

    private fun userInput() = Console.readLine()

    fun inputNumbers(): List<Int> {
        val input = userInput()
        inputCheck.checkInputNumbersException(input)
        return input.split(",").map { it.toInt() }.sorted()
    }

    fun inputBonus(): Int {
        val input = userInput()
        inputCheck.checkBonusException(input)
        return input.toInt()
    }

}