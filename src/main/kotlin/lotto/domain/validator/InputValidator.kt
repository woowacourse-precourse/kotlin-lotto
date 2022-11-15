package lotto.domain.validator

import lotto.domain.common.ERROR_MESSAGE
import lotto.domain.common.THOUSAND

object InputValidator {

    /** 사용자가 입력한 구입 금액이 올바른지 검증 **/
    fun validateTicketMoney(input: String) {
        (input.isThousandUnit() && input.isDigit()).let { isCorrectInput ->
            if (!isCorrectInput) {
                println(ERROR_MESSAGE.format("금액은 1000원 단위로 입력해야 합니다."))
                throw java.lang.IllegalArgumentException()
            }
        }
    }

    private fun String.isDigit(): Boolean =
        this.all { eachChar -> eachChar.isDigit() }

    private fun String.isThousandUnit(): Boolean =
        this.toInt() / THOUSAND > 0
}