package lotto.input

import lotto.util.Input
import lotto.util.InputValidateReal
import lotto.util.OutputMessage

interface PayedMoney {
    fun inputUserMoney(): String
    fun checkMoneyStandard(userInputNumber: String?)
}

class PayedMoneyImpl : PayedMoney {

    override fun inputUserMoney(): String {
        OutputMessage().payedMoneyMsg()
        val userInputNumber = Input().inputUser()
        checkMoneyStandard(userInputNumber)
        OutputMessage().lottoCountMsg(userInputNumber.replace("000", ""))
        return userInputNumber.replace("000", "")
    }


    override fun checkMoneyStandard(userInputNumber: String?) {
        userInputNumber ?: throw IllegalArgumentException()
        val checkMoney = userInputNumber.split(",").toList() as MutableList<String>
        InputValidateReal().checkInputMessagePatten(checkMoney)
        println(userInputNumber.toInt())
        if (userInputNumber.toInt() % 1000 != 0 || userInputNumber.toInt() == 0 ) {
            OutputMessage().errorMsg()
            throw IllegalArgumentException()
        }
    }
}