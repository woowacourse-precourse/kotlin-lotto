package lotto.input

import lotto.util.Input

interface WinningNumber {
    fun inputWinningNumber(): String
    fun checkLottoStandard(userInputNumber: String?)
}

class WinningNumberImpl : WinningNumber {

    private val userInputNumber = Input().inputUser()

    override fun inputWinningNumber(): String {
        println("당첨 번호를 입력해 주세요.")
        checkLottoStandard(userInputNumber)
        return userInputNumber
    }

    override fun checkLottoStandard(userInputNumber: String?) {
        userInputNumber ?: throw IllegalArgumentException()
        val checkLotto = userInputNumber.split(",").toList() as MutableList<String>
        for (i in checkLotto)
            if (i.toInt() >= 46 || i.toInt() < 1) {
                println("[ERROR]")
                throw IllegalArgumentException()
            }
        lotto.util.InputValidateReal().checkInputMessagePatten(checkLotto)
        if (checkLotto.distinct().size != 6) {
            println("[ERROR]")
            throw IllegalArgumentException()
        }
    }
}