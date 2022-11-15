package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.*

class InputView {
    // 1000원 단위의 구입 금액을 입력 받는다.
    fun askUserMoney(): Int {
        val money = Console.readLine()
        validateUserMoney(money)
        return money.toInt()
    }

    fun validateUserMoney(money: String) {
        handleMixedCharCase(money)
        if(money.toInt() % MONEY_UNIT != 0)
            throw IllegalArgumentException(DIVISION_ERROR_MSG)
    }

    // 쉼표로 구분된 당첨 번호를 입력 받는다.
    fun askWinningNumbers(): List<Int> {
        val input = Console.readLine()
        return validateWinningNumbers(input)
    }

    // 쉼표로 구분된 문자열을 정수 리스트로 변환한다.
    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = mutableListOf<Int>()
        input.split(",").map {
            handleMixedCharCase(it)
            handleOutOfRangeCase(it.toInt())
            if (numbers.contains(it.toInt()))
                throw IllegalArgumentException(WINNING_DUPLICATE_ERROR_MSG)
            numbers.add(it.toInt())
        }
        handleSizeMismatchCase(numbers.size)
        handleEmptyCase(numbers) // 비어있는 원소가 있는지 검사하기
        return numbers
    }

    private fun handleEmptyCase(numbers: List<Int>) {

    }

    // 보너스 번호를 입력 받는다.
    fun askBonusNumber(winningNumbers: List<Int>): Int {
        val input = Console.readLine()
        return validateBonusNumber(input, winningNumbers)
    }

    fun validateBonusNumber(input: String, winningNumbers: List<Int>): Int {
        handleMixedCharCase(input)
        handleOutOfRangeCase(input.toInt())
        if(winningNumbers.contains(input.toInt()))
            throw IllegalArgumentException(BONUS_DUPLICATE_ERROR_MSG)
        return input.toInt()
    }

    private fun handleMixedCharCase(token: String) {
        for (ch in token) {
            if (!Character.isDigit(ch))
                throw IllegalArgumentException(MIXED_CHAR_ERROR_MSG)
        }
    }

    private fun handleOutOfRangeCase(num: Int) {
        if (num !in MIN_VALUE..MAX_VALUE)
            throw IllegalArgumentException(RANGE_BOUNDS_ERROR_MSG)
    }

    private fun handleSizeMismatchCase(size: Int) {
        if (size != LOTTO_NUM_LIMIT)
            throw IllegalArgumentException(SIZE_BOUNDS_ERROR_MSG)
    }
}