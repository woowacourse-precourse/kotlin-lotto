package lotto.domain

import camp.nextstep.edu.missionutils.Console.readLine

private const val INPUT_NOT_NATURAL_NUMBER = "[ERROR] 로또번호는 자연수여야합니다."
private const val INVALID_NUMBER_RANGE = "[ERROR] 입력된 숫자가 1에서 45사이가 아닙니다."
private const val INVALID_NUMBER_OF_WINNING_NUMBERS = "[ERROR] 당첨 번호는 6개여야합니다."
private const val BONUS_DUPLICATED = "[ERROR] 보너스 번호가 당첨 번호와 중복되었습니다."
private const val LOTTO_SIZE = 6

class LottoMachine {
    private val _winningNumbers = mutableListOf<Int>()
    val winningNumbers: List<Int> get() = _winningNumbers

    private var _bonusNumber: Int = 0
    val bonusNumber: Int get() = _bonusNumber

    fun publishWinningNumber(input: String = readLine()) {
        val numbers: List<Int> = input
            .split(",")
            .map { number ->
                checkInputValid(number)
                number.toInt()
            }
        checkNumberOfWinningNumbers(numbers)
        _winningNumbers.addAll(numbers)
    }

    private fun checkNumberOfWinningNumbers(numbers: List<Int>) {
        if (numbers.size != LOTTO_SIZE) {
            throw IllegalArgumentException(INVALID_NUMBER_OF_WINNING_NUMBERS)
        }
    }

    fun publishBonusNumber(number: String = readLine()) {
        checkInputValid(number)
        checkDuplication(number)
        _bonusNumber = number.toInt()
    }

    private fun checkDuplication(number: String) {
        if (winningNumbers.contains(number.toInt())) {
            throw IllegalArgumentException(BONUS_DUPLICATED)
        }
    }

    private fun checkInputValid(input: String) {
        isNumber(input)
        isNumberInRange(input.toInt())
    }

    private fun isNumber(number: String) {
        if (!number.all { Character.isDigit(it) }) {
            throw IllegalArgumentException(INPUT_NOT_NATURAL_NUMBER)
        }
    }

    private fun isNumberInRange(number: Int) {
        if (number !in 1..45) {
            throw IllegalArgumentException(INVALID_NUMBER_RANGE)
        }
    }
}
