package lotto.user

import camp.nextstep.edu.missionutils.Console
import java.util.regex.Matcher
import java.util.regex.Pattern

fun inputUser(): String {
    val userInputMoney = Console.readLine()
    return userInputMoney.toString()
}

fun inputUserNumber(): String {
    val userInputNumber=inputUser()
    println(userInputNumber.replace("000", ""))
    return userInputNumber.replace("000", "")
}

fun checkInputMessagePatten( checkOverlap: MutableList<String>) {
    val regax="^[0-9]*$"
    val pattern: Pattern = Pattern.compile(regax)
    for (inputNum in checkOverlap) {
        val matcher: Matcher = pattern.matcher(inputNum)
        if (matcher.find().toString() == "false") throw IllegalArgumentException()
    }
}