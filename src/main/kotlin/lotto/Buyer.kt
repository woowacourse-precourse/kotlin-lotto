package lotto

import camp.nextstep.edu.missionutils.Console

class Buyer {

    fun getPurchaseAmount(): Int {
        var judgment = Judgment()

        println("구입금액을 입력해 주세요.")
        var money = Console.readLine()
        return judgment.checkPurchaseAmount(money)
    }
}