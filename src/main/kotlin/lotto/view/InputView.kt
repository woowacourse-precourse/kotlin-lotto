package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.LottoNumber
import lotto.Money

class InputView {
    fun inputPurchaseAmount(): Int {
        val money = Console.readLine()
        Money(money)
        return money.toInt()
    }

    fun inputWinningNumber(): List<Int> {
        val winningNumbers = Console.readLine()
            .split(",")
            .map { number ->
                number.toInt()
            }
        checkWinningNumbers(winningNumbers)
        return winningNumbers
    }
    
    private fun checkWinningNumbers(winningNumbers: List<Int>) {
        winningNumbers.map { number ->
            LottoNumber(number)
        }
    }
}