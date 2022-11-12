package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.LottoNumber
import lotto.Money

class InputView {
    fun inputPurchaseAmount(): Int {
        val money = Console.readLine()
        Money(money)
        return money.toInt()
    }
}