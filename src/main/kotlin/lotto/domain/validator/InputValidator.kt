package lotto.domain.validator

import lotto.domain.common.*

object InputValidator {

    /** 사용자가 입력한 구입 금액이 올바른지 검증 **/
    fun validateTicketMoney(input: String): ErrorType {
        (input.isDigit() && input.isThousandUnit()).let { isCorrectInput ->
            if (!isCorrectInput) return ErrorType.MONEY
        }
        return ErrorType.NORMAL
    }

    /** 사용자가 입력한 로또 번호 6개가 올바른지 검증 **/
    fun validateWinningLottoNumbers(input: String): ErrorType {
        if (input.split(",").contains(""))
            return ErrorType.RANGE

        val inputs = input.split(",")

        return if (!inputs.isWinningNumberCount())
            ErrorType.COUNT
        else if (!(inputs.isCorrectRange() && inputs.isWinningNumberAllDigit()))
            ErrorType.RANGE
        else if (inputs.isWinningNumberDuplicated())
            ErrorType.DUPLICATION
        else ErrorType.NORMAL
    }

    /** 사용자가 입력한 보너스 번호가 올바른지 검증 **/
    fun validateBonusLottoNumber(winningNumbers: List<Int>, bonusNumber: String): ErrorType {
        return if (!(bonusNumber.isDigit() && bonusNumber.isCorrectRange()))
            ErrorType.RANGE
        else if (winningNumbers.contains(bonusNumber.toInt()))
            ErrorType.DUPLICATION
        else ErrorType.NORMAL
    }

    private fun String.isDigit(): Boolean =
        this.all { eachChar -> eachChar.isDigit() }

    private fun String.isThousandUnit(): Boolean =
        this.toInt() / THOUSAND > 0

    private fun String.isCorrectRange(): Boolean =
        this.toInt() in START_LOTTO_NUMBER..END_LOTTO_NUMBER

    private fun List<String>.isWinningNumberCount(): Boolean =
        this.size == LOTTO_NUMBER_COUNT

    private fun List<String>.isWinningNumberAllDigit(): Boolean =
        this.all { numberString -> numberString.isDigit() }

    private fun List<String>.isWinningNumberDuplicated(): Boolean =
        this.size != this.toSet().size

    private fun List<String>.isCorrectRange(): Boolean =
        this.all { numberString -> numberString.isCorrectRange() }
}