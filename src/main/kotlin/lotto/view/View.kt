package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.CheckException
import lotto.model.Price

class View {

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

    fun inputWinningNum() : MutableList<Int>{
        println("\n"+inputWinningNumber)
        var winningNum = Console.readLine().split(",").map{it.toInt() }.toMutableList()

        check.checkListSize(winningNum)
        check.checkRange(winningNum)
        check.checkDuplicate(winningNum)

        println(winningNum)
        println("\n")
        return winningNum
    }

    fun inputBonusNum(winningNum : MutableList<Int>) : Int{
        println(inputBonusNumber)
        var bonusNum = Console.readLine().toInt()
        println("\n")

        check.checkBonusNum(bonusNum, winningNum)

        return bonusNum
    }

    fun outputSameLotto(three : Int , four : Int , five : Int ,fiveBonus : Int , six : Int){

        println(Price.THREE.reward + three + "개")
        println(Price.FOUR.reward + four + "개")
        println(Price.FIVE.reward + five + "개")
        println(Price.FIVE_WITH_BONUS.reward + fiveBonus + "개")
        println(Price.SIX.reward + six + "개")
    }

    fun outputYield(yield : String){
        println("총 수익률은 "+ `yield` + "%입니다.")
    }




}