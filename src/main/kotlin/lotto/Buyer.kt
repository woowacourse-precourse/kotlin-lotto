package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Constant.Companion.REQUEST_MONEY

class Buyer {

    fun getPurchaseAmount(): Int {
        var judgment = Judgment()

        println("$REQUEST_MONEY")
        payMoney = Console.readLine()
        return judgment.checkPurchaseAmount(payMoney)
    }
    companion object {
        var payMoney = ""
    }
}