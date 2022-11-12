package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import utils.Constants
import utils.Constants.ERROR_NOT_1000WON_MESSAGE
import utils.Constants.ERROR_OUT_OF_RANGE_MESSAGE
import utils.Constants.ERROR_OVER_COUNT_MESSAGE
import utils.Constants.ERROR_REDUPLICATED_NUMBER_MESSAGE

class Rule {
    fun checkPurchaseAmount(input: String) {
        // 1. 숫자 외 문자일 경우
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException(ERROR_OUT_OF_RANGE_MESSAGE)
        // 2. 1000원 단위인지
        if (amount % 1000 != 0) throw IllegalArgumentException(ERROR_NOT_1000WON_MESSAGE)
    }

    fun checkWinningNumbers(numbers: List<String>) {
        require(numbers.size == 6) { ERROR_OVER_COUNT_MESSAGE }
        require(!isReduplicateNumber(numbers)) { ERROR_REDUPLICATED_NUMBER_MESSAGE }
        require(!isNumberOutOfRange(numbers)) { ERROR_OUT_OF_RANGE_MESSAGE }
    }

    private fun isReduplicateNumber(numbers: List<String>): Boolean {
        for (i in 0 until numbers.size - 1) {
            if (numbers[i] == numbers[i + 1])
                return true
        }
        return false
    }

    private fun isNumberOutOfRange(numbers: List<String>): Boolean {
        for (number in numbers) {
            if (number.toInt() < 1 || number.toInt() > 45)
                return true
        }
        return false
    }

    fun checkBonusNumber(lottoNumbers: List<Int>, bonusNumber: Int) {
        require(!lottoNumbers.contains(bonusNumber)) { ERROR_REDUPLICATED_NUMBER_MESSAGE }
        require(bonusNumber in 1..45) { ERROR_OUT_OF_RANGE_MESSAGE }
    }

}