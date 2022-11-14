package lotto

import camp.nextstep.edu.missionutils.Console
import message.Message

class Number {

    fun inputWinningNumber(): List<String> {
        println("\n${Message.INPUT_WINNING_NUM.message}")
        var winnings = Console.readLine().split(",")
        winnings.forEach {
            checkNumberScope(it.toInt())
        }
        for (i in 0..4) {
            for (j in i + 1..5) {
                if (winnings[i] == winnings[j]) {
                    throw IllegalArgumentException("[ERROR] numbers에 중복된 숫자가 포함되어 있습니다.")
                }
            }
        }
        return winnings
    }

    fun inputBonusNumber(): Int {
        println("\n${Message.INPUT_BONUS_NUM.message}")
        var bonusNum = Console.readLine().toInt()
        checkNumberScope(bonusNum)
        return bonusNum
    }

    private fun checkNumberScope(num: Int) {
        if (num < 1 || num > 45) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }
}