package lotto

import camp.nextstep.edu.missionutils.Console.readLine

private const val UNIT_NOT_THOUSAND = "[ERROR] 구입금액은 1000원 단위여야합니다."
private const val MONEY_NOT_NATURAL_NUMBER = "[ERROR] 구입금액은 자연수여야합니다."
private const val THOUSAND_UNIT = "000"

class Reader {
    fun enterMoney(): Int {
        val money = readLine()
        isNumber(money)
        isThousandUnit(money)
        return money.toInt()
    }

    private fun isNumber(inputMoney: String) {
        if (!inputMoney.all { Character.isDigit(it) }) {
            throw IllegalArgumentException(MONEY_NOT_NATURAL_NUMBER)
        }
    }

    private fun isThousandUnit(inputMoney: String) {
        if (inputMoney.takeLast(3) != THOUSAND_UNIT) {
            throw IllegalArgumentException(UNIT_NOT_THOUSAND)
        }
    }
}
