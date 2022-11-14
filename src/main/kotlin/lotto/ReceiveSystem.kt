package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Model.Lotto
import lotto.Model.Money
import lotto.View.OutputView

class ReceiveSystem {
    private val validator = ValidateInput()

    fun receiveMoney(): Money {
        OutputView().printStartMessage()
        val money = Console.readLine()
        if (validator.validateNumber(money))
            return Money(money.toInt())
        return Money(0)
    }

    fun receiveWinningNumber(): Lotto {
        OutputView().printWinningNumberMessage()
        val input = Console.readLine()
        val winningNumber = input.split(",")
        val result = mutableListOf<Int>()
        for (num in winningNumber)
            if (validator.validateNumber(num))
                result.add(num.toInt())
        return Lotto(result.sorted())
    }

    fun receiveBonusNumber(winningNumber: Lotto): Int {
        OutputView().printBonusNumberMessage()
        val bonusNum = Console.readLine()
        if (validator.validateNumber(bonusNum)
            && validator.validateRange(bonusNum.toInt())
            && validator.validateDuplicationBonusNum(winningNumber, bonusNum.toInt())
        )
            return bonusNum.toInt()
        return 0
    }
}