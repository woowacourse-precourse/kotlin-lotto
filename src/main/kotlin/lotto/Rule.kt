package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import utils.Constants
import utils.Constants.ERROR_NOT_1000WON_MESSAGE
import utils.Constants.ERROR_OUT_OF_RANGE_MESSAGE
import utils.Constants.ERROR_OVER_COUNT_MESSAGE
import utils.Constants.ERROR_REDUPLICATED_NUMBER_MESSAGE
import utils.Constants.RANGE_END
import utils.Constants.RANGE_START
import utils.Constants.STANDARD_WON

class Rule {
    fun checkPurchaseAmount(input: String) {
        // 1. 숫자 외 문자일 경우
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException(ERROR_OUT_OF_RANGE_MESSAGE)
        // 2. 1000원 단위인지
        if (amount % STANDARD_WON != 0) throw IllegalArgumentException(ERROR_NOT_1000WON_MESSAGE)
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
            if (number.toInt() < RANGE_START || number.toInt() > RANGE_END)
                return true
        }
        return false
    }

    fun checkBonusNumber(lottoNumbers: List<Int>, bonusNumber: Int) {
        require(!lottoNumbers.contains(bonusNumber)) { ERROR_REDUPLICATED_NUMBER_MESSAGE }
        require(bonusNumber in RANGE_START..RANGE_END) { ERROR_OUT_OF_RANGE_MESSAGE }
    }

}