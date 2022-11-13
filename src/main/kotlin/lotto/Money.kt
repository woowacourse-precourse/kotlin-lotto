package lotto

import camp.nextstep.edu.missionutils.Console

class Money {
    var money: String = "-1"
    fun inputMoney(): String {
        try {
            println(Message.INPUT_MONEY_MASSAGE)

            val money = Console.readLine()

            Exceptions.checkMoney(money)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 입력 금액이 올바르지 않습니다.")
        }

        return money
    }
}