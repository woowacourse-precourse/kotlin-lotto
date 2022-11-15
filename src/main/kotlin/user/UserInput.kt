package user

import camp.nextstep.edu.missionutils.Console
import exception.ExceptionCheck

class UserInput {
    fun getUserPrice(): String {
        val userInput = Console.readLine()
        return ExceptionCheck().checkValidPrice(userInput)
    }
}