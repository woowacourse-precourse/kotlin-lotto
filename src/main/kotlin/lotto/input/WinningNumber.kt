package lotto.input

import lotto.util.Input
import lotto.util.OutputMessage

interface WinningNumber {
    fun inputWinningNumber(): String
    fun checkLottoStandard(userInputNumber: String?)
}

class WinningNumberImpl : WinningNumber {

    override fun inputWinningNumber(): String {
        OutputMessage().winningNumberMsg()
        val userInputNumber = Input().inputUser()
        checkLottoStandard(userInputNumber)
        println(userInputNumber)
        return userInputNumber
    }

    override fun checkLottoStandard(userInputNumber: String?) {
        userInputNumber ?: throw IllegalArgumentException()
        val checkLotto = userInputNumber.split(",").toList() as MutableList<String>
        for (i in checkLotto)
            if (i.toInt() >= 46 || i.toInt() < 1) {
                OutputMessage().errorMsg()
                throw IllegalArgumentException()
            }
        lotto.util.InputValidateReal().checkInputMessagePatten(checkLotto)
        if (checkLotto.distinct().size != 6) {
            OutputMessage().errorMsg()
            throw IllegalArgumentException()
        }
    }
}