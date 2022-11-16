package lotto

import camp.nextstep.edu.missionutils.Console

private const val ERROR_CODE = "[ERROR] "
private const val ERROR_DEFAULT = "잘못된 입력입니다"
private const val ERROR_DOLLAR = "1000원 단위로 입력해야합니다."
private const val ERROR_WINNING_NUBMER = "1부터 45사이의 중복되지 않은 수를 [,]로 구분하여 입력해야 합니다."
private const val ERROR_BONUS_NUBMER = "1부터 45사이의 당첨 번호에 포함되지 않는 수를 입력해야 합니다."

class LottoConsole {
    private val validChecker = LottoValidCheker()

    fun inputAmount(): Int { //금액 입력
        val amount: Int
        try {
            amount = Console.readLine().toInt()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ERROR_CODE + ERROR_DEFAULT)
        }

        if (validChecker.checkDollar(amount) || validChecker.checkPositive(amount)) {
            throw IllegalArgumentException(ERROR_CODE + ERROR_DOLLAR)
        }
        return amount
    }

    fun inputWinningNumbers(): Lotto { //당첨 번호 입력
        var winningNum: List<Int>
        try {
            var inputWinningNum = Console.readLine().split(',')
            winningNum = inputWinningNum.map { num -> num.toInt() }
        } catch (e: Exception) {
            throw IllegalArgumentException(ERROR_CODE + ERROR_DEFAULT)
        }
        if (validChecker.checkSize(winningNum) || validChecker.checkDuplicate(winningNum) || validChecker.checkRagne(winningNum)
        ) {
            throw IllegalArgumentException(ERROR_CODE + ERROR_WINNING_NUBMER)
        }
        return Lotto(winningNum)
    }

    fun inputBonusNum(winningNum: Lotto): Int { //보너스 번호 입력
        var bonusNum: Int
        try {
            bonusNum = Console.readLine().toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException(ERROR_CODE + ERROR_BONUS_NUBMER)
        }
        if (validChecker.checkBonusRange(bonusNum) || validChecker.checkBonusDuplicate(winningNum, bonusNum)) {
            throw IllegalArgumentException(ERROR_CODE + ERROR_BONUS_NUBMER)
        }
        return bonusNum
    }
}