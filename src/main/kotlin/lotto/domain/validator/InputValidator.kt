package lotto.domain.validator

import lotto.domain.common.THOUSAND

object InputValidator {
    /** 사용자가 입력한 구입 금액이 올바른지 검증 **/
    fun validateTicketMoney(input: String) {
        (input.isThousandUnit()).let { isCorrectInput ->
            if (!isCorrectInput) {

                throw java.lang.IllegalArgumentException()
            }
        }
    }

    private fun String.isThousandUnit(): Boolean =
        this.toInt()/THOUSAND > 0

}