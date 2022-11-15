package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class PurchaseLotto {

     private fun inputUserMoney() : Int{
        println("구매 금액을 입력해주세요.")
        val inputMoney = Console.readLine()
        return inputMoney.toInt()
    }


}