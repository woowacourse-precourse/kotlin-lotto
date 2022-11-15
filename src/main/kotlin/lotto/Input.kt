package lotto

import camp.nextstep.edu.missionutils.Console

class Input {
    fun inputMoney(): String {
        println("구입 금액을 입력해주세요.")
        return try {
            val money = Console.readLine()
            Exceptions.isInvalidMoney(money)
            money
        } catch (e: IllegalArgumentException) {
            println("$e")
            "ERROR"
        }
    }
}