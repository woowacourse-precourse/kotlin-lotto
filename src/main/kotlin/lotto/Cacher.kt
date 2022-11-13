package lotto

import camp.nextstep.edu.missionutils.Console.readLine

const val MONEY_NOT_NATURAL_NUMBER = "[ERROR] 구입금액은 자연수여야합니다."
const val UNIT_NOT_THOUSAND = "[ERROR] 구입금액은 1000원 단위여야합니다."
const val INPUT_IS_EMPTY = "[ERROR] 입력값이 비었습니다."
const val INPUT_STANDARD_UNIT = 1000

class Cacher {

    fun calculateNumberOfLottos(money: Int): Int {
        return money / INPUT_STANDARD_UNIT
    }

    fun enterPurchaseMoney(inputMoney: String = readLine()): Int {
        isInputValid(inputMoney)
        return inputMoney.toInt()
    }

    private fun isInputValid(inputMoney: String) {
        isInputEmpty(inputMoney)
        isNaturalNumber(inputMoney)
        isThousandUnit(inputMoney)
    }

    private fun isInputEmpty(inputMoney: String) {
        if (inputMoney.isNullOrEmpty()) {
            throw IllegalArgumentException(INPUT_IS_EMPTY)
        }
    }

    private fun isNaturalNumber(inputMoney: String) {
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
