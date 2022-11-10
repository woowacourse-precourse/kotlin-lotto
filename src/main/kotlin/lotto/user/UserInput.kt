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
    checkMoneyStandard(userInputNumber)
    return userInputNumber.replace("000", "")
}

fun checkLottoStandard(userInputNumber: String?) {
    val lottoRegax= "^[0-9]*$"
    userInputNumber ?: throw IllegalArgumentException()
    val checkLotto= userInputNumber.split(",").toList() as MutableList<String>
    for (i in checkLotto)
        if(i.toInt()>=46) throw IllegalArgumentException()
    checkInputMessagePatten(checkLotto)
    println(checkLotto.size)
    if(checkLotto.size !=6)throw IllegalArgumentException()

}
fun checkMoneyStandard(userInputNumber: String?) {
    userInputNumber ?: throw IllegalArgumentException()
    val checkMoney= userInputNumber.split(",").toList() as MutableList<String>
    checkInputMessagePatten(checkMoney)
    if(userInputNumber.toInt()%1000 !=0) throw IllegalArgumentException()
}
fun checkInputMessagePatten( checkOverlap: MutableList<String>) {
    val regax="^[0-9]*$"
    val pattern: Pattern = Pattern.compile(regax)
    for (inputNum in checkOverlap) {
        val matcher: Matcher = pattern.matcher(inputNum)
        if (matcher.find().toString() == "false") throw IllegalArgumentException()
    }
}