package lotto

import camp.nextstep.edu.missionutils.Console

class LottoAnswerNumberInputHandler {

    fun getLottoAnswer(): List<Int> {
        val input = Console.readLine()
        val res = input.split(",")
        inputValidation(res)
        return res.map { it.toInt() }
    }

    fun inputValidation(input: List<String>) {
        checkOnlyNumber(input)
        checkMinusInput(input)
        checkInRange(input)
    }

    private fun checkMinusInput(input: List<String>) {
        for (num in input) {
            if (num.toInt() < 0) {
                throw IllegalArgumentException(Constants.ERROR_MINUS_LOTTO_INPUT)
            }
        }
    }

    private fun checkInRange(input: List<String>) {
        for (num in input) {
            if (num.toInt() < 1 || num.toInt() > 45) {
                throw IllegalArgumentException(Constants.ERROR_OUT_OF_RANGE)
            }
        }
    }

    private fun checkOnlyNumber(input: List<String>) {
        val regexOnlyNumber = Regex("-?\\d+(\\.\\d+)?")
        for (num in input) {
            if (!regexOnlyNumber.matches(num)) {
                throw IllegalArgumentException(Constants.ERROR_ONLY_NUMBER)
            }
        }
    }
}