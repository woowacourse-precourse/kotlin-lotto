package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator.checkBonusNumber
import lotto.util.Validator.checkMoney
import lotto.util.Validator.checkWinningNumber
import java.lang.IllegalArgumentException

class InputVIew {

    fun inputMoney(): Int {
        val money: String
        try {
            money = Console.readLine()
            checkMoney(money)
            return money.toInt()
        } catch (e: IllegalArgumentException){
            throw IllegalArgumentException(e.message)
        }
    }

    fun inputWinningNumber(): List<Int> {
        val number: String
        try {
            number = Console.readLine()
            return checkWinningNumber(number)
        } catch (e: IllegalArgumentException){
            throw IllegalArgumentException(e.message)
        }
    }

    fun inputBonusNumber(): Int {
        val number: String
        try {
            number = Console.readLine()
            checkBonusNumber(number)
            return number.toInt()
        } catch (e: IllegalArgumentException){
            throw IllegalArgumentException(e.message)
        }
    }
/*    fun buyLotto(): String{
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
    }*/
}