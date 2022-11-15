package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.CheckException
import lotto.model.Strings

class View {

    var inputPurchaseMoney = Strings.INPUT_PURCHASE_CENTENCE.reward
    var inputWinningNumber = Strings.INPUT_WINNING_NUMBER.reward
    var inputBonusNumber = Strings.INPUT_BONUS_NUMBER.reward
    val check = CheckException()

    fun inputPurchasemoney(): String {

        println(inputPurchaseMoney)
        var amount = Console.readLine()
        check.checkInput(amount)
        println()
        println()

        return amount
    }

    fun inputWinningNum(): MutableList<Int> {
        println("\n" + inputWinningNumber)
        var winningNum = Console.readLine().split(",").map { it.toInt() }.toMutableList()

        check.checkLottoGroup(winningNum)

        println(winningNum)
        println("\n")
        return winningNum
    }

    fun inputBonusNum(winningNum: MutableList<Int>): Int {
        println(inputBonusNumber)
        var bonusNum = Console.readLine().toInt()
        println("\n")

        check.checkBonusNum(bonusNum, winningNum)

        return bonusNum
    }

    fun outputSameLotto(three: Int, four: Int, five: Int, fiveBonus: Int, six: Int) {

        println(Strings.THREE.reward + three + "개")
        println(Strings.FOUR.reward + four + "개")
        println(Strings.FIVE.reward + five + "개")
        println(Strings.FIVE_WITH_BONUS.reward + fiveBonus + "개")
        println(Strings.SIX.reward + six + "개")
    }

    fun outputYield(yield: String) {
        println("총 수익률은 " + `yield` + "%입니다.")
    }

}