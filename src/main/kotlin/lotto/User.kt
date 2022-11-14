package lotto

import camp.nextstep.edu.missionutils.Console

class User {
    fun userInput() : Lotto{
        println("\n당첨 번호를 입력해 주세요.")
        var user = Console.readLine()
        var token = user.split(",")
        val userInputNum = mutableListOf<Int>()

        for(i in token){
            LottoError.checkIsNum(i)
            userInputNum.add(i.toInt())
        }
        return Lotto(userInputNum.toList())
    }
}