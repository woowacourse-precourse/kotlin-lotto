package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.InputValidator.validateBonusNumber
import lotto.InputValidator.validateWinningNumber

object WinningNumberGenerator {
    lateinit var generatedWinningNumber: Array<Int>
        private set

    fun generateWinningNumber() {
        val winningNumber = Console.readLine().split(",")

        if (!validateWinningNumber(winningNumber)) {
            throw java.lang.IllegalArgumentException("[ERROR]")
        }
        generatedWinningNumber = winningNumber.map { it.toInt() }.toTypedArray()
    }

    val generatedBonusNumber: Int by lazy{
        val bonusNumber=Console.readLine()

        if (!validateBonusNumber(bonusNumber, generatedWinningNumber)) {
            throw java.lang.IllegalArgumentException("[ERROR]")
        }
        bonusNumber.toInt()
    }
}