package lotto

import camp.nextstep.edu.missionutils.Console

class Input {
    fun inputMoney(): String {
        return try {
            val money = Console.readLine()
            Exceptions.checkMoney(money)
            money
        } catch (e: IllegalArgumentException) {
            println("$e")
            "ERROR"
        }
    }

    fun inputWinningNumber(): List<String> {
        return try {
            val winningNumber = Console.readLine()
                .replace(" ", "")
                .split(",")
            Exceptions.checkWiningNumber(winningNumber)
            winningNumber
        } catch (e: IllegalArgumentException) {
            println("$e")
            emptyList()
        }
    }

    fun inputBonusNumber(winningNumber: List<String>): String {
        return try {
            val bonus = Console.readLine().replace(" ", "")
            Exceptions.checkBonus(winningNumber, bonus)
            bonus
        } catch (e: IllegalArgumentException) {
            println("$e")
            ""
        }
    }

}