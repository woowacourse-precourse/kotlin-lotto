package lotto

import camp.nextstep.edu.missionutils.Console.readLine

const val INVALID_NUMBER_RANGE = "입력된 숫자가 1에서 45사이가 아닙니다."
const val INVALID_NUMBER_OF_WINNING_NUMBERS = "당첨 번호는 6개여야합니다."

class LottoMachine {
    private val _winningNumbers = mutableListOf<Int>()
    val winningNumbers: List<Int> get() = _winningNumbers

    private var _bonusNumber: Int = 0
    val bonusNumber: Int get() = _bonusNumber

    fun publishWinningNumber(input: String = readLine()) {
        val numbers = input.split(",").map { number ->
            checkInputValid(number)
            number.toInt()
        }
        checkNumberOfWinningNumbers(numbers)
        _winningNumbers.addAll(numbers)
    }

    fun publishBonusNumber(number: String = readLine()) {
        checkInputValid(number)
        _bonusNumber = number.toInt()
    }

    private fun checkNumberOfWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException(INVALID_NUMBER_OF_WINNING_NUMBERS)
        }
    }

    private fun checkInputValid(input: String) {
        isNumber(input)
        isNumberInRange(input.toInt())
    }

    private fun isNumber(number: String) {
        if (!number.all { Character.isDigit(it) }) {
            throw IllegalArgumentException(MONEY_NOT_NATURAL_NUMBER)
        }
    }

    private fun isNumberInRange(number: Int) {
        if (number !in 1..45) {
            throw IllegalArgumentException(INVALID_NUMBER_RANGE)
        }
    }
}
