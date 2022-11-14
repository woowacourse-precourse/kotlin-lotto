package lotto.domain

import camp.nextstep.edu.missionutils.Console
import util.Printers

class User {

    // 로또 구매 금액 입력
    fun inputMoney(): String {
        Printers.userInputMoney()
        return Console.readLine()
    }
}