package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.CheckException
import lotto.model.Price

class Input {

    var inputPurchaseMoney = Price.INPUT_PURCHASE_CENTENCE.reward
    var inputWinningNumber = Price.INPUT_WINNING_NUMBER.reward
    var inputBonusNumber = Price.INPUT_BONUS_NUMBER.reward
    val check = CheckException()



    fun inputPurchasemoney() : String{

        println(inputPurchaseMoney)
        var amount = Console.readLine()
        check.checkInt(amount)
        check.checkMod(amount)
        println()
        println()

        return amount
    }

    fun inputWinningNum() : MutableList<String>{
        println(inputWinningNumber)
        var winningNum = Console.readLine().split(",").map{it }.toMutableList()
        check.checkListSize(winningNum)
        check.checkRange(winningNum)
        check.checkDuplicate(winningNum)

        println(winningNum)
        return winningNum
    }

    fun inputBonusNum(winningNum : MutableList<String>) : String{
        println(inputBonusNumber)
        var bonusNum = Console.readLine()

        check.checkBonusNum(bonusNum, winningNum)

        return bonusNum
    }





}