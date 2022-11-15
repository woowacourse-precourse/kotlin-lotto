package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator

object Input {

    fun buyLotto(): String{
        Print.requestMoney()
        var payMoney = Console.readLine()
        return Validator.checkPurchaseAmount(payMoney)
    }

    fun winningNumber(): List<Int>{
        println()
        Print.winningLotto()
        var input = Console.readLine()
        return Validator.checkWinningNumber(input)
    }

    fun bonusNumber(): String{
        println()
        Print.bonusNumber()
        var input = Console.readLine()
        return Validator.checkBonusNumber(input)
    }
}