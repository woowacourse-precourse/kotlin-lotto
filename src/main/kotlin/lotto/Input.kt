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
            println("[ERROR]")
            "ERROR"
        }
    }

    fun inputWinningNumber(): List<String> {
        println("\n당첨 번호를 입력해주세요.")
        return try {
            val lotteryNumbers = Console.readLine()
                .replace(" ", "")
                .split(",")
            Exceptions.isInvalidWinningNumber(lotteryNumbers)
            lotteryNumbers
        } catch (e: IllegalArgumentException) {
            println("$e")
            emptyList()
        }
    }

    fun inputBonusNumber(winningNumber: List<String>): String {
        println("\n보너스 번호를 입력해주세요.")
        return try {
            val bonusNumber = Console.readLine()
            Exceptions.isInvalidBonusNumber(winningNumber, bonusNumber)
            bonusNumber
        } catch (e: IllegalArgumentException) {
            println("$e")
            "ERROR"
        }
    }
}