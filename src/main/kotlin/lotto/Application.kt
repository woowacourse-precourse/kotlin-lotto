package lotto

import camp.nextstep.edu.missionutils.Console
import java.util.regex.Pattern

const val userInputMsg = "구입금액을 입력해 주세요."
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
        //예외처리 할 것
    }

    return userInput.toInt()
}

private fun checkItOnlyContainsNumber(userInput: String) : Boolean {
    return Pattern.matches("^[0-9]*$", userInput)
}