package lotto

import org.mockito.internal.matchers.Not
import org.mockito.internal.matchers.Null

class CheckException(amount: String) {

    init {
        checkInt(amount)
        checkMod(amount)
    }

    fun checkMod(amount: String) {

        if (amount.toInt() % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요!")
        }

    }

    fun checkInt(amount: String) {

        if (!isNumber(amount)) {
            throw IllegalArgumentException("[ERROR] 금액을 숫자 형태로 입력해주세요!")
        }
    }

    fun isNumber(string: String): Boolean {
        return !string.isNullOrEmpty() && string.matches(Regex("\\d+"))
    }

}