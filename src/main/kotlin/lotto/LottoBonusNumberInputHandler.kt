package lotto

import camp.nextstep.edu.missionutils.Console

class LottoBonusNumberInputHandler(private val lottoAnswerList: List<Int>) {

    fun getBonusNumber(): Int {
        var input = Console.readLine()
        inputValidation(input)
        return input.toInt()
    }

    private fun inputValidation(input: String) {
        checkOnlyNumber(input)
        checkMinusInput(input)
        checkInRange(input)
        checkDuplicate(input)
    }

    private fun checkMinusInput(input: String) {
        if (input.toInt() < 0) {
            throw IllegalArgumentException(Constants.ERROR_MINUS_LOTTO_INPUT)
        }
    }

    private fun checkInRange(input: String) {
        if (input.toInt() < 1 || input.toInt() > 45) {
            throw IllegalArgumentException(Constants.ERROR_OUT_OF_RANGE)
        }
    }

    private fun checkOnlyNumber(input: String) {
        val regexOnlyNumber = Regex("-?\\d+(\\.\\d+)?")
        if (!regexOnlyNumber.matches(input)) {
            throw IllegalArgumentException(Constants.ERROR_ONLY_NUMBER)
        }

    }

    private fun checkDuplicate(input: String) {
        if (lottoAnswerList.contains(input.toInt())) {
            throw IllegalArgumentException(Constants.ERROR_DUPLICATE)
        }
    }
}