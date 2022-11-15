package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class PurchaseLotto {

     private fun inputUserMoney() : Int{
        println("구매 금액을 입력해주세요.")
        val inputMoney = Console.readLine()
        inputMoneyException(inputMoney)
        return inputMoney.toInt()
    }

    fun userLottoCount(): String {
        var lottoCount  =0
         lottoCount = inputUserMoney() / 1000
        return "${lottoCount}개를 구매했습니다."
    }

     fun inputMoneyException(money : String){
        var payment = money.toInt()
        if(payment % 1000 !=0){
            throw IllegalArgumentException("[ERROR] 금액이 1000원으로 나누어 떨어지지 않습니다." )
        }
    }
}