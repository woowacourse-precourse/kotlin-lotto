package lotto

import camp.nextstep.edu.missionutils.Console

class MoneyInputHandler {

    fun getInputMoney(): String {
        val input = Console.readLine()
        inputValidation(input)
        return input
    }

    fun inputValidation(input: String): String {
        if (checkOnlyNumber(input)) {
            throw IllegalArgumentException(Constants.ERROR_ONLY_NUMBER)
        }
        if (checkMinusValue(input.toInt())) {
            throw IllegalArgumentException(Constants.ERROR_MINUS_INPUT)
        }
        if (checkDivideByUnit(input.toInt())) {
            throw IllegalArgumentException(Constants.ERROR_DIVIDE_UNIT)
        }

        if (checkUnderMinimumValue(input.toInt())) {
            throw IllegalArgumentException(Constants.ERROR_UNDER_MINIMUM)
        }


        return input

    }

    private fun checkMinusValue(input: Int): Boolean {
        return input < 0
    }

    private fun checkUnderMinimumValue(input: Int): Boolean {
        return input < 1000
    }

    private fun checkDivideByUnit(input: Int): Boolean {
        return input % 1000 != 0
    }

    private fun checkOnlyNumber(input: String): Boolean {
        val regexOnlyNumber = Regex("-?\\d+(\\.\\d+)?")
        return !regexOnlyNumber.matches(input)

    }


}