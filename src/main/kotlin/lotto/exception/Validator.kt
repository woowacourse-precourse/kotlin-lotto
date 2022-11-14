package lotto.exception

import lotto.domain.Lotto

private enum class ErrorMessage(val message: String) {
    NOT_NUMBER("[ERROR] 숫자만 입력해주세요."),
    NOT_1000_NUMBER("[ERROR] 금액이 1,000원으로 나누어 떨어지지 않습니다."),
    NOT_COMMA("[ERROR] 번호는 쉼표로 구분해주세요."),
    NOT_6_NUMBER("[ERROR] 당첨 번호는 여섯개 입니다."),
    DUPLICATE("[ERROR] 중복 없이 입력해주세요."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 당첨 번호와 중복 없이 입력해주세요."),
    OUT_OF_RANGE("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.")
}

object Validator {

    fun checkMoneyInput(input: String): Int {
        val money = input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessage.NOT_NUMBER.message)
        if (money % 1000 != 0) {
            throw IllegalArgumentException(ErrorMessage.NOT_1000_NUMBER.message)
        }
        return money
    }
}
