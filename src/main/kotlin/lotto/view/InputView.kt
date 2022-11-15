package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.lotto.BonusNumber
import lotto.domain.lotto.LottoNumber
import lotto.domain.lotto.WinningNumber
import lotto.domain.money.Money

class InputView {
    fun inputPurchaseAmount(): String {
        val money = Console.readLine()
        Money(money)
        return money
    }

    fun inputWinningNumber(): List<Int> {
        val winningNumbers = getWinningNumbers(Console.readLine())
        checkWinningNumbers(winningNumbers)
        return winningNumbers
    }

    fun inputBonusNumber(winningNumbers: List<Int>): Int {
        val bonusNumber = Console.readLine().toInt()
        LottoNumber(bonusNumber)
        BonusNumber(winningNumbers, bonusNumber)
        return bonusNumber
    }

    private fun checkWinningNumbers(winningNumbers: List<Int>) {
        winningNumbers.map { number -> LottoNumber(number) }
    }

    private fun getWinningNumbers(winningNumbers: String): List<Int> {
        WinningNumber(winningNumbers)
        return winningNumbers
            .split(",")
            .map { number -> number.toInt() }
    }
}