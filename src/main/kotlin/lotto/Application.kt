package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException
import java.util.regex.Pattern

const val userInputMsg = "구입금액을 입력해 주세요."
const val errorHeader = "[ERROR]"
const val lottoEachPrice = 1000
fun main() {
    getUserInputPrice()
}
private fun getUserInputPrice() {
    println(userInputMsg)
    val userInput = Console.readLine()
    checkRegexAndTranslateToInt(userInput)
}

private fun checkRegexAndTranslateToInt(userInput : String) : Int {
    if (!checkItOnlyContainsNumber(userInput)) {
        Error.showError(ErrorType.NotOnlyNumber)
    }
    if (!checkItCanDivideWithThousand(changeStringToInt(userInput))) {
        Error.showError(ErrorType.NotDivideWithThousand)
    }

    return changeStringToInt(userInput)
}

private fun checkItOnlyContainsNumber(userInput: String) : Boolean {
    return Pattern.matches("^[0-9]*$", userInput)
}

private fun checkItCanDivideWithThousand(userInputPrice : Int) : Boolean {
    return (userInputPrice % lottoEachPrice == 0)
}

private fun changeStringToInt(userInput : String) : Int {
    return userInput.toInt()
}