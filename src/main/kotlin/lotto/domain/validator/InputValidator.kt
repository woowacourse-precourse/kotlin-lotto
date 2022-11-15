package lotto.domain.validator

import lotto.domain.common.ERROR_FORMAT
import lotto.domain.common.THOUSAND

object InputValidator {

    /** 사용자가 입력한 구입 금액이 올바른지 검증 **/
    fun validateTicketMoney(input: String): Boolean =
        input.isDigit() && input.isThousandUnit()


    /** 사용자가 입력한 로또 번호 6개가 올바른지 검증 **/
    fun validateWinningLottoNumbers(input: List<String>) {
        (input.isWinningNumberCount() && input.isWinningNumberAllDigit() && input.isCorrectRange()).let { isCorrectInput ->
            if (!isCorrectInput) {
                println(ERROR_FORMAT.format("로또 번호는 1부터 45 사이의 6자리 숫자를 ,(쉼표) 단위로 입력해야 합니다.\n예) 1,2,3,4,5,6"))
                throw java.lang.IllegalArgumentException()
            }
        }
    }

    /** 사용자가 입력한 보너스 번호가 올바른지 검증 **/
    fun validateBonusLottoNumber(input: String) {

    }

    private fun String.isDigit(): Boolean =
        this.all { eachChar -> eachChar.isDigit() }

    private fun String.isThousandUnit(): Boolean =
        this.toInt() / THOUSAND > 0

    private fun List<String>.isWinningNumberCount(): Boolean =
        this.size == 6

    private fun List<String>.isWinningNumberAllDigit(): Boolean =
        this.all { numberString -> numberString.isDigit() }

    private fun List<String>.isCorrectRange(): Boolean =
        this.all { numberString -> numberString.toInt() in 1..45 }
}