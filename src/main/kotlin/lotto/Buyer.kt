package lotto

import camp.nextstep.edu.missionutils.Console

class Buyer {
    companion object {
        var payMoney = ""
    }
    fun getPurchaseAmount(): Int {
        var judgment = Judgment()

        println("구입금액을 입력해 주세요.")
        payMoney = Console.readLine()
        return judgment.checkPurchaseAmount(payMoney)
    }
}