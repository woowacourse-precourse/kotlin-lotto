package lotto.util

import camp.nextstep.edu.missionutils.Console


class Input{
     fun inputUser(): String {
        val userInputMoney = Console.readLine()
         userInputMoney ?: println("[Error]")
         if (userInputMoney!!.isEmpty()){
             print("[ERROR]")
             throw IllegalArgumentException()
         }
        return userInputMoney.toString()
    }
}