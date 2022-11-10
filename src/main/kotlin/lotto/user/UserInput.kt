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