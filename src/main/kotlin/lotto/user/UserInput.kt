package lotto.user

import camp.nextstep.edu.missionutils.Console
import java.util.regex.Matcher
import java.util.regex.Pattern

fun inputUser(): String {
    val userInputMoney = Console.readLine()
    return userInputMoney.toString()
}

fun inputUserMoney(): String {
    val userInputNumber=inputUser()
    checkMoneyStandard(userInputNumber)
    println(userInputNumber.replace("000", ""))
    return userInputNumber.replace("000", "")
}
fun checkMoneyStandard(userInputNumber: String?) {
    userInputNumber ?: throw IllegalArgumentException()
    val checkMoney= userInputNumber.split(",").toList() as MutableList<String>
    checkInputMessagePatten(checkMoney)
     try {
        userInputNumber.toInt()%1000 !=0
    }catch (e:IllegalArgumentException){
        println("[ERROR]$e")
    }

}
fun inputUserLotto(): String {
    val userInputNumber=inputUser()
    checkLottoStandard(userInputNumber)
    println(userInputNumber)
    return userInputNumber
}
fun checkLottoStandard(userInputNumber: String?) {
    userInputNumber ?: throw IllegalArgumentException()
    val checkLotto= userInputNumber.split(",").toList() as MutableList<String>
    for (i in checkLotto){
        try {
            i.toInt()>=46

        }catch  (e:IllegalArgumentException){
            println("[ERROR]")
        }
    }
    checkInputMessagePatten(checkLotto)
    try {
        checkLotto.size !=6
    }catch (e:IllegalArgumentException){
        println("[ERROR]")
    }
}
fun checkInputMessagePatten( checkOverlap: MutableList<String>) {
    val regax="^[0-9]*$"
    val pattern: Pattern = Pattern.compile(regax)
    for (inputNum in checkOverlap) {
        val matcher: Matcher = pattern.matcher(inputNum)
        try {
            matcher.find().toString() == "false"
        }catch (e:IllegalArgumentException){
            println("[ERROR]")
        }
    }
}