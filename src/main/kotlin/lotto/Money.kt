package lotto

import camp.nextstep.edu.missionutils.Console

class Money {
    var money: String = ""
    fun inputMoney() {
        try {
            println(Message.INPUT_MONEY_MASSAGE)

            money = Console.readLine()

            Exceptions.checkMoney(money)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 입력 금액이 올바르지 않습니다.")
            money = "ERROR"
        }


    }

    fun countLotteryTickets(): Int{
        return money.toInt()/1000
    }
}