package lotto

import camp.nextstep.edu.missionutils.Console

class Input {
    fun inputMoney(): String {
        return try {
            var money = Console.readLine()
            Exceptions.checkMoney(money)
            money
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 입력 금액이 올바르지 않습니다.")
            "ERROR"
        }
    }

    fun inputWinningNumber(): List<String> {
        val winningNumber = Console.readLine()
            .replace(" ", "")
            .split(",")
        Exceptions.checkWiningNumber(winningNumber)
        return winningNumber
    }

    fun inputBonusNumber(winningNumber : List<String>): String {
        val bonus = Console.readLine().replace(" ", "")
        Exceptions.checkBonus(winningNumber, bonus)
        return bonus
    }

}