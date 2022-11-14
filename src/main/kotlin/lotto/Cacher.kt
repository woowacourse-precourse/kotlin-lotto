package lotto

import camp.nextstep.edu.missionutils.Console.readLine

private const val UNIT_NOT_THOUSAND = "[ERROR] 구입금액은 1000원 단위여야합니다."
private const val MONEY_NOT_NATURAL_NUMBER = "[ERROR] 구입금액은 자연수여야합니다."
private const val PURCHASE_STANDARD_UNIT = 1000

class Cacher {

    fun calculateNumberOfLottos(money: Int): Int {
        return money / PURCHASE_STANDARD_UNIT
    }

    fun enterPurchaseMoney(inputMoney: String = readLine()): Int {
        isNumber(inputMoney)
        isThousandUnit(inputMoney)
        return inputMoney.toInt()
    }

    private fun isNumber(inputMoney: String) {
        if (!inputMoney.all { Character.isDigit(it) }) {
            throw IllegalArgumentException(MONEY_NOT_NATURAL_NUMBER)
        }
    }

    private fun isThousandUnit(inputMoney: String) {
        if (inputMoney.takeLast(3) != "000") {
            throw IllegalArgumentException(UNIT_NOT_THOUSAND)
        }
    }
}
