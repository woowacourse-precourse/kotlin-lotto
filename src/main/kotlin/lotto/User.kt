package lotto

import camp.nextstep.edu.missionutils.Console
import util.InputException

class User {
    private val inputCheck = InputException()

    private var _inputMoney = 0
    val inputMoney get() = _inputMoney

    fun inputMoney(): Int {
        val input = userInput()
        checkInputException(input)
        return input.toInt()
    }

    fun getLottos() = _inputMoney / 1000

    private fun checkInputException(input: String?) {
        with(inputCheck) {
            checkTypeException(input)
            inputMoneyException(input!!)
        }
    }

    private fun userInput() = Console.readLine()

    fun inputNumbers(): List<Int> {
        val input = userInput()
        checkInputNumbersException(input)
        return input.toList().map { it.digitToInt() }
    }

    fun inputBonus(): Int {
        val input = userInput()
        checkBonusException(input)
        return input.toInt()
    }

    private fun checkBonusException(input: String?) {
        with(inputCheck) {
            checkNullException(input)
            checkTypeException(input)
            checkRangeException(input?.toList()?.map { it.digitToInt() }!!)
        }
    }

    private fun checkInputNumbersException(input: String?) {
        with(inputCheck) {
            checkNullException(input)
            input?.split(",")?.let { this.checkTypeException(it) }
            val numbers = input?.split(",")?.map { it.toInt() }!!
            checkRangeException(numbers)
            checkOverlapException(numbers)
        }
    }
}