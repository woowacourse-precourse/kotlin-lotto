package util

import util.Constants.RANGE_END
import util.Constants.RANGE_START

import util.Messages.ERROR_BONUS_NUMBER_DUPLICATE
import util.Messages.ERROR_BONUS_NUMBER_FORMAT
import util.Messages.ERROR_BONUS_NUMBER_RANGE
import util.Messages.ERROR_INVALID_INPUT_MESSAGE
import util.Messages.ERROR_LOTTO_NUMBER_DUPLICATE
import util.Messages.ERROR_MESSAGE
import util.Messages.ERROR_NUMBER_FORMAT
import util.Messages.ERROR_NUMBER_RANGE

object Exceptions {

    fun isValidInputMoney(money: String) {
        // 1000원으로 나누어 떨어져야함
        // 숫자만 들어가야한다
        val regex = "(^[1-9])([0-9]*)(0{3})(0*)".toRegex()
        if (!regex.matches(money)) {
            throw IllegalArgumentException(ERROR_MESSAGE + ERROR_INVALID_INPUT_MESSAGE)
        }
    }

    // 로또번호가 중복되었는지 확인
    fun hasDuplicateNumbers(lotto: List<Int>) {
        if (lotto.size != lotto.toSet().size) {
            throw IllegalArgumentException(ERROR_MESSAGE + ERROR_LOTTO_NUMBER_DUPLICATE)
        }
    }

    // 당첨번호의 문자 입력값 확인
    fun isValidWinningNumber(winningNumber: List<String>): List<Int> {
        return winningNumber.map { number ->
            try {
                number.toInt()
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(ERROR_MESSAGE + ERROR_NUMBER_FORMAT)
            }
        }
    }

    // 당첨번호의 숫자 범위 예외 확인
    fun isValidRangeWinningNumber(winningNumber: List<Int>) {
        winningNumber.forEach { number ->
            if (number < RANGE_START || RANGE_END < number) {
                throw IllegalArgumentException(ERROR_MESSAGE + ERROR_NUMBER_RANGE)
            }
        }
    }


    // 보너스 번호 예외 확인
    fun String.isValidBonusNumber() {
        try {
            this.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_MESSAGE + ERROR_BONUS_NUMBER_FORMAT)
        }
    }

    // 보너스 번호 숫자 범위 예외 확인
    fun Int.isValidRangeBonusNumber() {
        if (this < RANGE_START || RANGE_END < this) {
            throw IllegalArgumentException(ERROR_MESSAGE + ERROR_BONUS_NUMBER_RANGE)
        }
    }

    // 보너스 번호와 당첨번호 중복 확인
    fun Int.isUniqueBonusNumber(winningNumber: List<Int>) {
        if (winningNumber.contains(this)) {
            throw IllegalArgumentException(ERROR_MESSAGE + ERROR_BONUS_NUMBER_DUPLICATE)
        }
    }
}