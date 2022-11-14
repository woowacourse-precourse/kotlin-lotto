package lotto

import lotto.Util
import camp.nextstep.edu.missionutils.Console

class LottoVendingMachine {
    val util = Util()
    fun inputMoney(): String{
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
        return input
    }

    fun countMoney(input: String): Int{
        val error = util.isNumInt(input)
        if(!error)
            return -1
        val money = input.toInt()
        isEnoughMoney(money)
        val amount = isMoney1000(money)
        println("${amount}개를 구매했습니다.")
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