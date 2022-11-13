package lotto.View

import camp.nextstep.edu.missionutils.Console
import lotto.Model.Lotto
import lotto.Model.Money
import lotto.ValidateInput

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

    fun receiveBonusNumberInput(): Int {
        val validator = ValidateInput()
        val bonusNum = Console.readLine()
        if (validator.validateNumber(bonusNum) && validator.validateRange(bonusNum.toInt()))
            return bonusNum.toInt()
        return 0
    }
}