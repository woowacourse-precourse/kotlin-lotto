package lotto

import camp.nextstep.edu.missionutils.Console
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
}