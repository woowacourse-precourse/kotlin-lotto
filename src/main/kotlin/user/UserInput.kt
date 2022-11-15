package user

import camp.nextstep.edu.missionutils.Console
import exception.ExceptionCheck

class UserInput {
    fun getUserPrice(): String {
        val userInput = Console.readLine()
        return ExceptionCheck().checkValidPrice(userInput)
    }

    fun getWinningNumbers(): List<Int> {
        val userInput = Console.readLine()
        return ExceptionCheck().checkValidWinningNumbers(userInput)
    }
}