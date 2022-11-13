package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun receiveMoneyInput(): Money {
        val money = Console.readLine()
        if (ValidateInput().validateNumber(money))
            return Money(money.toInt())
        return Money()
    }

    fun receiveWinningNumberInput(): Lotto {
        val input = Console.readLine()
        val winningNumber = input.split(",")
        val result = winningNumber.map { it.toInt() }
        return Lotto(result.sorted())
    }

    fun receiveBonusNumberInput(): String {
        return Console.readLine()
    }
}