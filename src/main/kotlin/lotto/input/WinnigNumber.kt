package lotto.input

import camp.nextstep.edu.missionutils.Console
import java.util.regex.Matcher
import java.util.regex.Pattern

class WinningNumber() {

    private val userInputNumber= lotto.util.input().inputUser()

    fun inputWinningNumber(): String {
        println("당첨 번호를 입력해 주세요.")
        checkLottoStandard(userInputNumber)
        return userInputNumber
    }

    fun checkLottoStandard(userInputNumber: String?) {
        userInputNumber ?: throw IllegalArgumentException()
        val checkLotto = userInputNumber.split(",").toList() as MutableList<String>
        for (i in checkLotto)
            if (i.toInt() >= 46 || i.toInt() < 1) {
                println("[ERROR]")
                throw IllegalArgumentException()
            }
        lotto.util.InputValidable().checkInputMessagePatten(checkLotto)
        if (checkLotto.distinct().size != 6) {
            println("[ERROR]")
            throw IllegalArgumentException()
        }
    }


}