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

    fun inputWinningNumber(): List<String> {
        println("당첨 번호를 입력해주세요.")
        val lotteryNumbers = Console.readLine()
            .replace(" ", "")
            .split(",")

        return lotteryNumbers
    }

    fun inputBonusNumber(): String {
        println("보너스 번호를 입력해주세요.")
        val bonusNumber = Console.readLine()
        return bonusNumber
    }
}