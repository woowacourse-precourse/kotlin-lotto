package lotto.util

import camp.nextstep.edu.missionutils.Console

class input() {
    fun inputUser(): String {
        val userInputMoney = Console.readLine()
        return userInputMoney.toString()
    }
}