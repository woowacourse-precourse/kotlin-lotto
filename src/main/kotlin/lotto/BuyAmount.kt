package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.Constant.Companion.costNotRegularErrorMessage
import lotto.Constant.Companion.emptyErrorMessage
import lotto.Constant.Companion.inputAmountMessage
import lotto.Constant.Companion.lottoCost
import lotto.Constant.Companion.notIntErrorMessage
import lotto.Constant.Companion.regularMax
import lotto.Constant.Companion.regularMin

class BuyAmount {

    init {
        println(inputAmountMessage)
    }
    fun inputAmount(): Int {
        val inputAmount: String = readLine().trim()
        exception(inputAmount)
        return inputAmount.toInt() / lottoCost
    }

    fun exception(inputAmount: String?) {
        if (inputAmount!!.isEmpty()) {
            println(emptyErrorMessage)
            throw IllegalArgumentException(emptyErrorMessage)
        }

        if (!inputAmount.all { it in regularMin..regularMax}) {
            println(notIntErrorMessage)
            throw IllegalArgumentException(notIntErrorMessage)
        }

        if (inputAmount.toInt() % lottoCost != 0) {
            println(costNotRegularErrorMessage)
            throw IllegalArgumentException(costNotRegularErrorMessage)
        }
    }
}