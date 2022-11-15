package lotto.util

import camp.nextstep.edu.missionutils.Console


class Input {
    fun inputUser(): String {
        val userInputMoney = Console.readLine()
        if (userInputMoney!!.isEmpty()){
            print("[ERROR]")
            throw IllegalArgumentException()
        }
        return userInputMoney.toString()
    }
}