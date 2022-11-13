package lotto

import lotto.Util
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class LottoVendingMachine {
    val util = Util()
    fun inputMoney(): String{
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
        return input
    }

    fun countMoney(input: String): Int{
        util.isNumInt(input)
        val money = input.toInt()
        isEnoughMoney(money)
        val amount = isMoney1000(money)
        return amount
    }

    fun isEnoughMoney(money : Int): Boolean {
        if (money >= 1000)
            return true
        if (money < 1000) {
            throw IllegalArgumentException("[ERROR] 돈이 부족합니다.")
        }
        return false
    }

    fun isMoney1000(money: Int) : Int{
        if(money%1000!=0){
            println("거스름돈은 ${money%1000}원입니다.")
        }
        return money/1000
    }
}