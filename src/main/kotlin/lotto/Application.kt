package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException
import java.util.regex.Pattern

const val userInputMsg = "구입금액을 입력해 주세요."
const val errorHeader = "[ERROR]"
fun main() {
    getUserInputPrice()
}
private fun getUserInputPrice() {
    println(userInputMsg)
    val userInput = Console.readLine()
    checkRegexAndTranslateToInt(userInput)
}

private fun checkRegexAndTranslateToInt(userInput : String) : Int {
    if(!checkItOnlyContainsNumber(userInput)) {
        showErrorAndFinish(ErrorType.NotOnlyNumber.errorType)
    }

    return userInput.toInt()
}

private fun showErrorAndFinish(errorType : Int) {
    println("$errorHeader ${EnumError.ErrorType.checkErrorType(errorType)}")
    throw IllegalArgumentException()
}

private fun checkItOnlyContainsNumber(userInput: String) : Boolean {
    return Pattern.matches("^[0-9]*$", userInput)
}