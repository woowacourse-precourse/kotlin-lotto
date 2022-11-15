package lotto.util

import camp.nextstep.edu.missionutils.Console


class Input {
    fun inputUser(): String {
        val userInputMoney = Console.readLine()
        if (userInputMoney!!.isEmpty()){
            OutputMessage().errorMsg()
            throw IllegalArgumentException()
        }
        return userInputMoney.toString()
    }
}