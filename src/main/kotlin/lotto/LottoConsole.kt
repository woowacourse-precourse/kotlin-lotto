package lotto

import camp.nextstep.edu.missionutils.Console

private const val ERROR_CODE = "[ERROR] "
private const val ERROR_DEFAULT = "잘못된 입력입니다/"
private const val ERROR_DOLLAR = "1000원 단위로 입력해야합니다."

class LottoConsole {
    private val validChecker = LottoValidCheker()

    fun inputAmount(): Int {
        val amount: Int
        try {
            amount = Console.readLine().toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException(ERROR_CODE + ERROR_DEFAULT)
        }

        if (validChecker.checkDollar(amount) || validChecker.checkPositive(amount)) {
            throw java.lang.IllegalArgumentException(ERROR_CODE + ERROR_DOLLAR)
        }
        return amount
    }
}