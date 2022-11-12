package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.constants.Constant
import lotto.constants.Exception
import lotto.constants.Message

class Purchase {
    init {
        println(Message.MESSAGE_INPUT_MONEY)
    }

    fun inputMoney(): Int {
        return Console.readLine().toInt()
    }

    fun validateMoney(money: Int) {
        if (money % 1000 != 0) {
            throw IllegalArgumentException(Exception.EXCEPTION_INVALID_MONEY)
        }
    }
}