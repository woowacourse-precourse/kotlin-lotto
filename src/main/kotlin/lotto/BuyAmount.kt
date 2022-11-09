package lotto

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.Constant.Companion.costNotIntErrorMessage
import lotto.Constant.Companion.costNotRegularErrorMessage
import lotto.Constant.Companion.lottoCost
import lotto.Constant.Companion.regularMax
import lotto.Constant.Companion.regularMin

class BuyAmount {
    val cost = inputAmount()

    private fun inputAmount(): Int {
        val inputAmount = readLine()
        exception(inputAmount)
        return inputAmount.toInt()
    }

    private fun exception(inputAmount: String) {
        if (!inputAmount.all { it in regularMin..regularMax}) {
            println(costNotIntErrorMessage)
            throw IllegalArgumentException(costNotIntErrorMessage)
        }

        if (inputAmount.toInt() % lottoCost != 0) {
            println(costNotRegularErrorMessage)
            throw IllegalArgumentException(costNotRegularErrorMessage)
        }
    }
}