package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun inputMoney() : Int{
        println(Lotto.INPUTMONEY)
        var money = Console.readLine()

        LottoError.checkMoneyError(money)

        val numberOfLotto = money.toInt() / 1000
        println()
        println("$numberOfLotto" + Lotto.SHOWNUMOFLOTTERY)

        return money.toInt()
    }

    fun makeRandomNumber(money : Int) : MutableList<MutableList<Int>>{
        val lottery = mutableListOf<MutableList<Int>>()
        for (i in 0 until money/1000) {
            val randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottery.add(randomNumber)
            lottery[i].sort()
        }

        for (i in 0 until lottery.size) {
            println(lottery[i])
        }
        return lottery
    }
}