package lotto.domain.customer

import lotto.util.throwException

private const val UNIT_NOT_THOUSAND = "[ERROR] 구입금액은 1000원 단위여야합니다."
private const val MONEY_NOT_NATURAL_NUMBER = "[ERROR] 구입금액은 자연수여야합니다."
private const val THOUSAND_UNIT = "000"

class MoneyValidator {
    fun checkInputValid(money: String): Int {
        try {
            isNumber(money)
            isThousandUnit(money)
        } catch (e: Exception) {
            println(e.message)
            return -1
        }
        return money.toInt()
    }

    private fun isNumber(inputMoney: String) {
        if (!inputMoney.all { Character.isDigit(it) }) {
            throwException(MONEY_NOT_NATURAL_NUMBER)
        }
    }

    private fun isThousandUnit(inputMoney: String) {
        if (inputMoney.takeLast(3) != THOUSAND_UNIT) {
            throwException(UNIT_NOT_THOUSAND)
        }
    }
}
